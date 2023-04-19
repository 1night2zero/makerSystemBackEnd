package zstu.edu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import zstu.edu.eduservice.entity.EduSubject;
import zstu.edu.eduservice.entity.excel.SubjectData;
import zstu.edu.eduservice.service.EduSubjectService;
import zstu.edu.servicebase.exceptionhandler.MyException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.subjectService = eduSubjectService;
    }

    // 读取excel内容，一行一行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        System.out.println("****" + subjectData);
        if (subjectData == null) {
            throw new MyException(20001, "文件数据为空");
        }
        EduSubject existFirstSubject = this.existFirstSubject(subjectService, subjectData.getFirstSubjectName());
        // 判断一级分类是否重复
        if (existFirstSubject == null) {
            existFirstSubject = new EduSubject();
            existFirstSubject.setParentId("0");
            existFirstSubject.setTitle(subjectData.getFirstSubjectName());
            subjectService.save(existFirstSubject);
        }

        // 判断二级分类是否重复
        String pid = existFirstSubject.getId();
        EduSubject existSecondSubject = this.existSecondSubject(subjectService, subjectData.getSecondSubjectName(), pid);
        if (existSecondSubject == null) {
            existSecondSubject = new EduSubject();
            existSecondSubject.setParentId(pid);
            existSecondSubject.setTitle(subjectData.getSecondSubjectName());
            subjectService.save(existSecondSubject);
        }

    }

    // 判断一级分类不能重复添加
    private EduSubject existFirstSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return subjectService.getOne(wrapper);
    }

    // 判断二级分类不能重复添加
    private EduSubject existSecondSubject(EduSubjectService subjectService, String name, String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return subjectService.getOne(wrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }


}
