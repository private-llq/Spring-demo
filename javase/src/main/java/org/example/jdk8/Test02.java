package org.example.jdk8;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author llq
 */
public class Test02 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
    }
}
