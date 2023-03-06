package org.example.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liuliangqi
 * @date 2023/3/6 15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = -3047949434429677136L;

    private String name;
    private  int  age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }


    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        // 放大倍数减少重复冲突几率
        result = 31 * result + age;
        return result;
    }
}
