package com.spring.demo.easyexceldemo.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExportListener<T> {

    private BaseMapper<T> baseMapper;

    public ExportListener(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    private static final String DATA_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String CHARACTER_UTF_8 = "UTF-8";

    private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    private static final String CONTENT_DISPOSITION = "Content-Disposition";

    private static final String CACHE_CONTROL = "Cache-Control";

    private static final String NO_STORE = "no-store";

    private static final String MAX_AGE = "max-age=0";

    private static final Integer PAGE_SIZE = 10000;

    public void exportExcel(HttpServletResponse response, String sheetName, Class<T> pojoClass,
                            QueryWrapper<T> queryWrapper) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA_FORMAT);
        String nowTime = formatter.format(LocalDateTime.now());

        response.setContentType(CONTENT_TYPE);
        //设置字符集为utf-8
        response.setCharacterEncoding(CHARACTER_UTF_8);

        String fileName = sheetName.concat("(").concat(nowTime).concat(")").concat(".xlsx");

        //文件名乱码解决：用postman测正常，浏览器多了filename_=utf-8等字样
        response.setHeader(CONTENT_DISPOSITION,
                "attachment;filename=" + URLEncoder.encode(fileName, CHARACTER_UTF_8)
                        + ";filename*=utf-8''" + URLEncoder.encode(fileName, CHARACTER_UTF_8));

        //文件名乱码解决：postman测会乱码，但浏览器下载就正常
//        response.setHeader(CONTENT_DISPOSITION,
//                "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        //发送一个报头，告诉浏览器当前页面不进行缓存，每次访问的时间必须从服务器上读取最新的数据
        response.setHeader(CACHE_CONTROL, NO_STORE);
        response.addHeader(CACHE_CONTROL, MAX_AGE);

        // 这里 需要指定写用哪个class去写
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter excelWriter = EasyExcel.write(out, pojoClass).build();


        // 这里注意 如果同一个sheet只要创建一次
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();

        int totalCount = Math.toIntExact(baseMapper.selectCount(queryWrapper));

        int pageNumber = (int) Math.ceil((double) totalCount / (double) PAGE_SIZE);    //分页条数看情况

        // 去调用写入,根据数据库分页的总的页数来
        for (int i = 1; i <= pageNumber; i++) {
            //先定义一个空集合每次循环使他变成null减少内存的占用
            List<T> pageList = new ArrayList<>();
            Page<T> page = new Page<>(i, PAGE_SIZE);
            Page<T> cityIPage = baseMapper.selectPage(page, queryWrapper);
            pageList = cityIPage.getRecords();
            excelWriter.write(pageList , writeSheet);
            pageList.clear();
        }

        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
        out.flush();
    }
}
