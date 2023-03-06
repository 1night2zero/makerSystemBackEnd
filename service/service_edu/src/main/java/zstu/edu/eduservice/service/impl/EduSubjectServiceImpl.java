package zstu.edu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.multipart.MultipartFile;
import zstu.edu.eduservice.entity.EduSubject;
import zstu.edu.eduservice.entity.excel.SubjectData;
import zstu.edu.eduservice.listener.SubjectExcelListener;
import zstu.edu.eduservice.mapper.EduSubjectMapper;
import zstu.edu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zstu.edu.servicebase.exceptionhandler.MyException;

import java.io.InputStream;

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
}
