package org.example.springdemo.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/26 15:19
 * @description: 实体类
 */
public class StuEntity {
    //1.数组属性
    private String[] arrays;
    //2.list集合属性
    private List<String> list;
    //3.Map
    private Map<String,String> map;
    //4.Set
    private Set<String> set;

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "StuEntity{" +
                "arrays=" + Arrays.toString(arrays) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
