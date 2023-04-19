package zstu.edu.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ExcelListener extends AnalysisEventListener<ExcelData> {
    // 读取excel内容，一行一行读取
    @Override
    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
        System.out.println("****" + excelData);
    }

    // 读取表头内容
    @Override
    public void invokeHeadMap(java.util.Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }

    // 读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
