package com.spring.demo.easyexceldemo.converter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

import java.util.HashMap;
import java.util.Map;

public class EducationConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里是读的时候会调用
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
//        return context.getReadCellData().getStringValue();
        String readCellValue = context.getReadCellData().getStringValue();
        if(StrUtil.isNotEmpty(readCellValue)){
            Map<String, String> edMap = getEducation();
            for (Map.Entry<String, String> entry : edMap.entrySet()) {
                if (readCellValue.equals(entry.getValue())) {
                    readCellValue = entry.getKey();
                }
            }
        }
        return readCellValue;
    }

    /**
     * 这里是写的时候会调用
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        String cellValue = context.getValue();
        if(StrUtil.isNotEmpty(cellValue)){
            cellValue = getEducation().get(cellValue);
        }
        return new WriteCellData<>(cellValue);
    }

    public Map<String, String> getEducation(){
        Map<String, String> edMap = new HashMap<>();
        edMap.put("0", "大专");
        edMap.put("1", "本科");
        edMap.put("2", "硕士");
        edMap.put("3", "研究生");
        return edMap;
    }
}
