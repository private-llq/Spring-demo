package com.example.springimport.test;

import cn.idev.excel.FastExcel;
import cn.idev.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.springimport.test
 * @date 2025/1/6 14:56
 * @description: 公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 示例数据类
public class DemoData {
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("年龄")
    private String age;

    // 填充要写入的数据
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setName("name" + i);
            data.setAge("age" + i);
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {
        String fileName = "demo1.xlsx";
        // 创建一个名为“模板”的 sheet 页，并写入数据
        FastExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
}