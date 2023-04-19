package zstu.edu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\asus\\Desktop\\test.xlsx";

        // 判断文件是否存在
        try {
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File creation failed.");
                }
            }
//            EasyExcel.write(file, ExcelData.class).sheet("学生列表").doWrite(getData());  // 写
            EasyExcel.read(file, ExcelData.class, new ExcelListener()).sheet().doRead();    // 读

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 实现excel写操作
        // 实现excel读操作
//         EasyExcel.read(filePath, ExcelData.class, new ExcelListener()).sheet().doRead();
    }

    private static List<ExcelData> getData() {
        List<ExcelData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelData data = new ExcelData();
            data.setSno(i);
            data.setSname("test" + i);
            list.add(data);
        }
        return list;
    }
}
