package org.example.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileDemo8 {
    public static void main(String[] args) {
        //需求：统计一个文件夹中的每种文件出现的次数并打印
        //使用map集合进行数据统计，键 ---- 文件后缀名，值 ---- 次数

        File file = new File("C:\\Users\\liulq\\Desktop\\桌面资料");
        HashMap<String, Integer> hm = new HashMap<>();
        getCount(hm, file);
        //遍历map集合
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "------" + value);
        }
    }

    private static void getCount(HashMap<String, Integer> hm, File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                String fileName = f.getName();
                String[] fileNameArr = fileName.split("\\.");
                //数组最后一位是后缀名
                String fileEndName = fileNameArr[fileNameArr.length-1];
                if (hm.containsKey(fileEndName)) {
                    //已经存在
                    //将已经出现的次数取出来
                    Integer count = hm.get(fileEndName);
                    //这种文件又出现一次
                    count++;
                    hm.put(fileEndName, count);
                } else {
                    //不存在
                    //表示当前文件第一次出现
                    hm.put(fileEndName, 1);
                }
            } else {
                getCount(hm, f);
            }
        }
    }
}