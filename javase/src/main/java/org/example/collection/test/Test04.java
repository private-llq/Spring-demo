package org.example.collection.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/15 14:33
 */
public class Test04 {

    @Test
    public void testAddStudent() {
        //初始化
        List<Student.Course> courses = new ArrayList<Student.Course>();
        courses.add(new Student.Course("1","语言"));
        courses.add(new Student.Course("2","数学"));
        courses.add(new Student.Course("3","英语"));
        Student stu = new Student("101", "徐睿 ", courses);
        //以下两行是非法代码，不允许在外部被随意修改，只可以在构造器中完成
        stu.getCources().add(new Student.Course("3", "计算机"));
        stu.getCources().add(new Student.Course("4","机器学习"));
        System.out.println(stu);

    }

}
