package org.example.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author liuliangqi
 * @date 2023/1/3 9:48
 * 阿里巴巴代码规范-测试demo
 */
public class Test02 {

    // 使用 SLF4J：
//    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    //使用 JCL：
    private static final Log log = LogFactory.getLog(Test.class);

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


    public static void main(String[] args) {
        log.info("打印日志.......");
//        logger.debug("打印日志");
        System.out.println(Instant.now());
        System.out.println(Instant.MAX);
        long start = System.currentTimeMillis();
        System.out.println(Instant.ofEpochMilli(start));
        System.out.println(Instant.ofEpochSecond(start));
        System.out.println(Instant.EPOCH);
        System.out.println(Instant.MIN);
        System.out.println("-------------------------------");
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.of(1, 1, 1, 1, 1));
    }

    /*正例：超过 3 层的 if-else 的逻辑判断代码可以使用卫语句、策略模式、状态模式等来实现，其中卫语句
    示例如下：
    public void findBoyfriend (String man){
        if (man.isUgly()) {
            System.out.println("本姑娘是外貌协会的资深会员");
            return;
        }
        if (man.isPoor()) {
            System.out.println("贫贱夫妻百事哀");
            return;
        }
        if (man.isBadTemper()) {
            System.out.println("银河有多远，你就给我滚多远");
            return;
        }
        System.out.println("可以先交往一段时间看看");
    }*/

    /**
     * 【强制】当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null判断。
     *  反例：如下的代码输出是什么？
     *  以下为错误案例：
     */
    public static class SwitchString {
        public static void main(String[] args) {
            method(null);
        }

        public static void method(String param) {
            switch (param) {
                // 肯定不是进入这里
                case "sth":
                    System.out.println("it's sth");
                    break;
                // 也不是进入这里
                case "null":
                    System.out.println("it's null");
                    break;
                // 也不是进入这里
                default:
                    System.out.println("default");
            }
        }
    }



}