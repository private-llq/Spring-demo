package com.spring.demo.projecttest.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuliangqi
 * @date 2023/4/23 10:58
 */
public class Test {
    public static void main(String[] args) {
        String jsonStr = "[{\"type\":\"1\",\"codeList\":[{\"phone\":\"联系电话\",\"channel\":\"联系电话\"},{\"pushPhone\":\"推送电话\",\"channel\":\"推送电话\"}]}]";

        Gson gson = new Gson();
        List<Map<String, Object>> dataList = gson.fromJson(jsonStr, new TypeToken<List<Map<String, Object>>>() {
        }.getType());

        // 获取 codeList 并转换为 Map<String, List<Map<String, String>>> 对象
        List<Map<String, String>> codeList = (List<Map<String, String>>) dataList.get(0).get("codeList");

        Map<String, List<Map<String, String>>> channelMap = new HashMap<>();
        channelMap.put("codeList", codeList);

        // 输出 channelMap
        // System.out.println(channelMap);
        List<Map<String, String>> codeLists = (List<Map<String, String>>) dataList.get(0).get("codeList");
        for (Map<String, String> map : codeLists) {
            if (map.containsKey("phone")) {
                String phone = map.get("phone");
                System.out.println(phone);
            }
            if (map.containsKey("pushPhone")) {
                String pushPhone = map.get("pushPhone");
                System.out.println(pushPhone);
            }
        }
    }
}
