package org.example.jdk8;

import lombok.SneakyThrows;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    @SneakyThrows(Exception.class)
    public static void main(String[] args) {
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
        List<Integer> result= Stream.of(Arrays.asList(1,3), Arrays.asList(5,6)).flatMap(a->a.stream()).collect(Collectors.toList());
        System.out.println(result);

        Optional<String> name = Optional.of("Sanaulla");
        Optional empty = Optional.ofNullable(null);
        if (name.isPresent()) {
            //调用get()返回Optional值。
            System.out.println(name.get());
        }

        List<Person> list = new ArrayList<>();
        list.add(new Person("Chris", 20));
        list.add(new Person("Linda", 10));
        list.add(new Person("Jack", 30));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Person person : list) {
            System.out.println(person);
        }

//        // 如果没有值，默认值
//        Optional<String> emptyOptional = Optional.empty();
//        System.out.println("空Optional.orElse");
//        String orElse = emptyOptional.orElse(getDefault());
//        System.out.println("空Optional.orElseGet");
//        String orElseGet = emptyOptional.orElseGet(() -> getDefault());
//        System.out.println("空Optional.orElse结果："+orElse);
//        System.out.println("空Optional.orElseGet结果："+orElseGet);
//        System.out.println("--------------------------------");
//        // 如果没有值，默认值
//        Optional<String> stringOptional = Optional.of("hello");
//        System.out.println("有值Optional.orElse");
//        orElse = stringOptional.orElse(getDefault());
//        System.out.println("有值Optional.orElseGet");
//        orElseGet = stringOptional.orElseGet(() -> getDefault());
//        System.out.println("有值Optional.orElse结果："+orElse);
//        System.out.println("有值Optional.orElseGet结果："+orElseGet);


        // 如果没有值，抛出异常
//        Optional<String> emptyOptional = Optional.empty();
//        String value = emptyOptional.orElseThrow(() -> new Exception("发现空值"));
//        System.out.println(value););


        List<Integer> asList = Arrays.asList(1, 2, 3, 4);
        IntSummaryStatistics intSummaryStatistics = asList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());


        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.start();

        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        ageList.stream()
                .limit(3)
                .forEach(age -> System.out.print(age+","));
        ageList.stream()
                .skip(3)
                .forEach(age -> System.out.print(age+","));



        List<Integer> asList1 = Arrays.asList(11, 22, 13, 14, 25, 26);
        asList1.stream().collect(Collectors.groupingBy(age -> String.valueOf(age / 10))).forEach((v1,v2)->{
            System.out.println("年龄" + v1 + "0多岁的有：" + v2);
        });

//        Random random = new Random();
//        Stream<Integer> generate = Stream.generate(random::nextInt);
//        List<Integer> numberList = generate.limit(10000000).collect(Collectors.toList());
//        long start = System.currentTimeMillis();
//        int sum = numberList.stream()
//                .map(number -> number * 2)
//                .mapToInt(x -> x)
//                .sum();
//        long end = System.currentTimeMillis();
//        System.out.println("串行耗时："+(end - start)+"ms，和是:"+sum);
//
//        // 并行 - 把一千万个随机数，每个随机数 * 2 ，然后求和
//        start = System.currentTimeMillis();
//        sum = numberList.parallelStream()
//                .map(number -> number * 2)
//                .mapToInt(x -> x)
//                .sum();
//        end = System.currentTimeMillis();
//
//
//        System.out.println("并行耗时："+(end - start)+"ms，和是:"+sum);


        // 当前精确时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前精确时间：" + now);
        System.out.println("当前精确时间：" + now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + " " + now.getHour() + "-" + now.getMinute() + "-" + now.getSecond());

        // 获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期：" + localDate);
        System.out.println("当前日期：" + localDate.getYear() + "-" + localDate.getMonthValue() + "-" + localDate.getDayOfMonth());

        // 获取当天时间
        LocalTime localTime = LocalTime.now();
        System.out.println("当天时间：" + localTime);
        System.out.println("当天时间：" + localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());

        // 有时区的当前精确时间
        ZonedDateTime nowZone = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println("当前精确时间（有时区）：" + nowZone);
        System.out.println("当前精确时间（有时区）：" + nowZone.getYear() + "-" + nowZone.getMonthValue() + "-" + nowZone.getDayOfMonth() + " " + nowZone.getHour() + "-" + nowZone.getMinute() + "-" + nowZone.getSecond());


    }

    public static String getDefault() {
        System.out.println("   获取默认值中..run getDeafult method");
        return "hello";
    }
}
