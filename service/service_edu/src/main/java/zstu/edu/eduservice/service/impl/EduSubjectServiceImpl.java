package zstu.edu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import zstu.edu.eduservice.entity.EduSubject;
import zstu.edu.eduservice.entity.excel.SubjectData;
import zstu.edu.eduservice.entity.subject.FirstSubject;
import zstu.edu.eduservice.entity.subject.SecondSubject;
import zstu.edu.eduservice.listener.SubjectExcelListener;
import zstu.edu.eduservice.mapper.EduSubjectMapper;
import zstu.edu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zstu.edu.servicebase.exceptionhandler.MyException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-03-06
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        // 添加课程分类
        // 获取上传过来的文件，把文件内容读取出来
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (Exception e) {
            System.out.println("添加课程分类失败：" + e);
            throw new MyException(20002, "添加课程分类失败");
        }
    }

    // 课程分类列表（树形）
    @Override
    public List<FirstSubject> getAllOneTwoSubject() {
        // 查询所有一级分类
        QueryWrapper<EduSubject> firstWrapper = new QueryWrapper<>();
        firstWrapper.eq("parent_id", "0");
        List<EduSubject> firstSubjectList = baseMapper.selectList(firstWrapper);
        // 查询所有二级分类
        QueryWrapper<EduSubject> secondWrapper = new QueryWrapper<>();
        List<EduSubject> secondSubjectList = baseMapper.selectList(secondWrapper);
        ArrayList<FirstSubject> finalSubjectList = new ArrayList<>();
        // 封装一级分类
        for (EduSubject eduFirstSubject : firstSubjectList) {

            FirstSubject firstSubject = new FirstSubject();
            BeanUtils.copyProperties(eduFirstSubject, firstSubject);

            finalSubjectList.add(firstSubject);
            ArrayList<SecondSubject> secondFinalSubjectList = new ArrayList<>();

            // 遍历所有二级分类
            for (EduSubject eduSecondSubject : secondSubjectList) {
                // 判断二级分类的parentId和一级分类的id是否一样
                if (eduSecondSubject.getParentId().equals(eduFirstSubject.getId())) {
                    // 封装二级分类
                    SecondSubject secondSubject = new SecondSubject();
                    BeanUtils.copyProperties(eduSecondSubject, secondSubject);
                    secondFinalSubjectList.add(secondSubject);
                }
            }
            firstSubject.setChildren(secondFinalSubjectList);
        }
        return finalSubjectList;
    }

}
