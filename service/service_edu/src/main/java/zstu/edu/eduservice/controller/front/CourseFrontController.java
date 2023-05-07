package zstu.edu.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.CourseWebVoOrder;
import zstu.edu.commonutils.JwtUtils;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.client.OrderClient;
import zstu.edu.eduservice.entity.EduCourse;
import zstu.edu.eduservice.entity.chapter.ChapterVo;
import zstu.edu.eduservice.entity.frontvo.CourseFrontVo;
import zstu.edu.eduservice.entity.frontvo.CourseWebVo;
import zstu.edu.eduservice.service.EduChapterService;
import zstu.edu.eduservice.service.EduCourseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 1night2zero
 * @create 2021-11-12 15:33
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/courseFront")
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private OrderClient orderClient;

    // 条件查询带分页课程
    @PostMapping("/getFrontCourseList/{current}/{limit}")
    public R getFrontCourseList(@PathVariable long current,@PathVariable long limit,
                                @RequestBody(required = false) CourseFrontVo courseFrontVo){

        Page<EduCourse> coursePage = new Page<>(current, limit);
        Map<String, Object> map = courseService.getCourseFrontList(coursePage, courseFrontVo);
        return R.ok().data(map);
    }

    // 课程基本信息
    @GetMapping("/getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId, HttpServletRequest request){
        // 查询基本信息
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        // 查询章节小节
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);

        // 添加一个课程是否购买的信息查询
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        System.out.println("==================="+memberId);
        int buy = 0; // 0 未登录 1 已购买 2 未购买
        if (!StringUtils.isEmpty(memberId)){
            boolean buyCourse = orderClient.isBuyCourse(courseId, memberId);
            buy = buyCourse ? 1 : 2;
        }

        return R.ok().data("courseWebVo", courseWebVo)
                .data("chapterVideoList", chapterVideoList)
                .data("isBuy", buy);
    }

    // 根据课程id查询课程信息(订单模块使用)
    @PostMapping("/getCourseInfoOrder/{courseId}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable String courseId){
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(courseWebVo, courseWebVoOrder);
        return courseWebVoOrder;
    }
}
