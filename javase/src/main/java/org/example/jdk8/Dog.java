package org.example.jdk8;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dog {
    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    // 省略 get set toString
}
