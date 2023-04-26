package com.spring.demo.easyexceldemo.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author lijin
 * @version 1.0
 * @date 2022/12/28 17:47
 */
public class ExcelResponseHeaderUtil {
    //easyExcel默认响应头
    public static void setResponseHeader(HttpServletResponse response,String excelFileName ) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(excelFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }
    //公司响应头
    public static void setResponseHeaderGS(HttpServletResponse response,String excelFileName) throws UnsupportedEncodingException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(excelFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("ContentDisposition",fileName + ".xlsx");
    }
}
