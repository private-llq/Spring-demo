package org.example.jdk8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("牧羊犬", 1));
        list.add(new Dog("哈士奇", 2));
        list.add(new Dog("田园犬", 3));

        Map<String, Integer> dogMap = list.stream()
                .collect(Collectors.toMap(Dog::getName, Dog::getAge,
                        (oldData, newData) -> newData,
                        ConcurrentHashMap::new));
        System.out.println(dogMap.getClass());
    }
}
