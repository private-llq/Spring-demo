package org.example.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8
 * @date 2022/11/11 17:56
 * @Copyright 用jdk8 的常用API
 */
public class StreamTest {
    public static void main(String[] args) {
        Student a = new Student("a", 20);
        Student b = new Student("b", 18);
        Student c = new Student("c", 22);
        Student t = new Student("t", 22);
        Student d = new Student("d", 19);
        Student u = new Student("u", 19);
        Student e = new Student("e", 18);
        List<Student> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        //一、遍历该集合
//        list.forEach(System.out::println);
        //二、取出学生姓名
        List<String> nameList = list.stream().map(Student::getName).collect(Collectors.toList());
//        System.out.println(nameList);
//        三、取出年龄大于19岁的学生
        List<Student> studentList = list.stream().filter(s -> s.getAge() > 19).collect(Collectors.toList());
//        System.out.println(studentList);
//        四、取出不重复的学生年龄
        List<Integer> list1 = list.stream().map(Student::getAge).distinct().collect(Collectors.toList());
//        System.out.println(list1);
//        需求1：是否所有学生的年龄都在18岁以上（全匹配）
        /**
         * boolean anyMatch(Predicate<? super T> predicate); // 元素是否有任意一个满足条件
         * boolean allMatch(Predicate<? super T> predicate); // 元素是否都满足条件
         * boolean noneMatch(Predicate<? super T> predicate); // 元素是否都不满足条件
         */
        boolean flag = list.stream().map(Student::getAge).allMatch(o -> o > 18);
//      System.out.println(flag);
//      需求2：是否有学生的年龄大于21岁（任意匹配）
        boolean math = list.stream().map(Student::getAge).anyMatch(i -> i > 21);
//        System.out.println(math);
//      需求3：是否所有学生的年龄都不大于22岁（都不匹配）
        boolean findContext = list.stream().map(Student::getAge).anyMatch(i -> i > 21);
//        System.out.println(findContext);
//        需求，按照学生的年龄进行排序
//        list.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
//        默认是按照年龄进行升序输出，当然也可以降序输出，只要加上.reversed即可，如下图
//          list.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);
//        如果先按照年龄排序，再按照姓名进行排序，则可以写成：
//        list.stream().sorted(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName)).forEach(System.out::println);
//        需求：当前页是第2页，每页显示3条
//          list.stream().sorted(Comparator.comparingInt(Student::getAge)).skip((2 - 1) * 3) //(当前页-1)*每页显示条数
//                .limit(3)//每页显示条数
//                .forEach(System.out::println);
          //首先按照年龄进行排序，然后跳过上一页的数据，取出之后的limit条数据。
//          Map<Integer, List<Student>> group = list.stream().collect(Collectors.groupingBy(Student::getAge));
//          group.forEach((k, v) -> System.out.println("k:" + k + ",v:" + v.toString()));
          //需求：输出学生姓名用逗号隔开的字符串
            /**
             * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
             */
//           String str = list.stream().map(Student::getName).collect(Collectors.joining());
//           System.out.println(str);
//           需求1：求学生年龄的总和  mapToInt
//           int sum = list.stream().mapToInt(Student::getAge).sum();
//           System.out.println(sum);
//          需求2：求学生年龄的平均数 average()
            double average = list.stream()
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0.0);
            System.out.println(average);
//        注意，average()返回的是一个OptionalDouble，为了防止集合中没有元素时，我们必须使用orElse指定一个默认值。
//        同理，求最大值使用max，最小值使用min，都需要指定默认值。
    }
}
