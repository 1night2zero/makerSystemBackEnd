package zstu.edu.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import zstu.edu.eduservice.entity.EduCourse;
import zstu.edu.eduservice.entity.EduCourseDescription;
import zstu.edu.eduservice.entity.frontvo.CourseFrontVo;
import zstu.edu.eduservice.entity.frontvo.CourseWebVo;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;
import zstu.edu.eduservice.entity.vo.CoursePublishVo;
import zstu.edu.eduservice.mapper.EduCourseMapper;
import zstu.edu.eduservice.service.EduChapterService;
import zstu.edu.eduservice.service.EduCourseDescriptionService;
import zstu.edu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zstu.edu.eduservice.service.EduVideoService;
import zstu.edu.servicebase.exceptionhandler.MyException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduVideoService videoService;
    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 添加课程基本信息的方法
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 向课程表添加课程基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0) {
            throw new MyException(20001, "添加课程信息失败");
        }
        String cid = eduCourse.getId();
        // 向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);
        return cid;
    }

    // 根据课程id查询课程基本信息
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        // 查询课程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        // 查询描述表
        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());
        System.out.println(courseInfoVo);
        return courseInfoVo;
    }

    // 修改课程信息
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        // 修改课程表
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if (update == 0) {
            throw new MyException(20001, "修改课程信息失败");
        }
        // 修改描述表
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(courseInfoVo.getId());
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.updateById(courseDescription);
    }

    // 根据课程id查询课程确认信息
    @Override
    public CoursePublishVo getPublishCourseInfo(String id) {
        // 调用mapper
        CoursePublishVo coursePublishVo = baseMapper.getPublishCourseInfo(id);
        return coursePublishVo;
    }

    // 删除课程
    @Override
    public void removeCourse(String courseId) {
        // 删除失败，有很大概率是课程是逻辑删除的缘故导致的。。。。。可以检查一下。//已经解决
        // 根据课程id删除小节
        videoService.removeVideoByCourseId(courseId);
        // 根据课程id删除章节
        chapterService.removeChapterByCourseId(courseId);
        // 根据课程id删除描述
        courseDescriptionService.removeById(courseId);
        // 根据课程id删除课程本身
        int result = baseMapper.deleteById(courseId);
        if (result == 20001) {
            throw new MyException(20001, "删除失败");
        }
    }

    @Override
    public Map<String, Object> getCourseFrontList(Page<EduCourse> coursePage,
                                                  CourseFrontVo courseFrontVo) {

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectParentId())) {
            wrapper.eq("subject_parent_id", courseFrontVo.getSubjectParentId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectId())) {
            wrapper.eq("subject_id", courseFrontVo.getSubjectId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getBuyCountSort())) {
            wrapper.orderByDesc("buy_count");
        }
        if (!StringUtils.isEmpty(courseFrontVo.getGmtCreateSort())) {
            wrapper.orderByDesc("gmt_create");
        }
        if (!StringUtils.isEmpty(courseFrontVo.getPriceSort())) {
            wrapper.orderByDesc("price");
        }
        baseMapper.selectPage(coursePage, wrapper);

        List<EduCourse> records = coursePage.getRecords();
        long current = coursePage.getCurrent();
        long pages = coursePage.getPages();
        long size = coursePage.getSize();
        long total = coursePage.getTotal();
        boolean hasNext = coursePage.hasNext();
        boolean hasPrevious = coursePage.hasPrevious();
        Map<String, Object> map = new HashMap<>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);
        return map;
    }

    @Override
    public CourseWebVo getBaseCourseInfo(String courseId) {
        return baseMapper.getBaseCourseInfo(courseId);
    }

    @Override
    public List<EduCourse> getTopCourses(int limit) {
        // 使用 Redis 缓存
        String cacheKey = "top_courses:" + limit;
        List<EduCourse> courses = (List<EduCourse>) redisTemplate.opsForValue().get(cacheKey);
        if (courses == null) {
            // 缓存中没有数据，查询数据库
            QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("view_count").last("limit " + limit);
            courses = baseMapper.selectList(queryWrapper);
            // 将查询结果存入缓存
            redisTemplate.opsForValue().set(cacheKey, courses);
        }
        return courses;
    }
}
