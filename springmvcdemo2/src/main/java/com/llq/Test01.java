package com.llq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.llq
 * @date 2024/1/10 8:53
 * @description: 公司
 */
public class Test01 {
    public static void main(String[] args) {

        String start = "2024-01-01"; // 时间区间的开始日期字符串
        String end = "2024-01-02"; // 时间区间的结束日期字符串
        String dateString = "2024-01-03"; // 要比较的日期字符串

        List<Map<String,Object>>  maps = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(start);
            Date endDate = dateFormat.parse(end);
            Date date = dateFormat.parse(dateString);

            if (date.compareTo(startDate) > 0 && date.compareTo(endDate) < 0) {
                // 日期在区间内
                System.out.println("日期在区间内");
            } else {
                // 日期不在区间内
                System.out.println("日期不在区间内");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
