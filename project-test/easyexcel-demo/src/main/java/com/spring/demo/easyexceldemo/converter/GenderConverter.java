package com.spring.demo.easyexceldemo.converter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

public class GenderConverter implements Converter<String> {

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
            readCellValue = ("男").equals(readCellValue) ? "1":"0";
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
            cellValue = ("1").equals(context.getValue()) ? "男":"女";
        }
        return new WriteCellData<>(cellValue);
    }

}
