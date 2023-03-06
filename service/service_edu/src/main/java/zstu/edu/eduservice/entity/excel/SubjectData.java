package zstu.edu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SubjectData {

    // 一级分类
    @ExcelProperty(index = 0)
    private String firstSubjectName;
    // 二级分类
    @ExcelProperty(index = 1)
    private String secondSubjectName;

}
