package org.example.juc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author llq
 */
public class DateUtils {
    public static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        System.out.println(DateUtils.df.get().format(new Date()));
    }

}