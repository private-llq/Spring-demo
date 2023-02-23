package org.example.collection;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/2/23 15:47
 */
@Slf4j
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("llq");
        list.add("LLQ");
        log.info("list",list);
    }
}
