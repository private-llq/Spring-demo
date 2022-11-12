package org.example.se;


/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2022/11/11 12:16
 * @Copyright return、continue和break的区别
 */
public class ForTest2 {
        public static void main(String[] args) {
//            for (int i = 0; i < 3; i++) {
//                System.out.println("i的值是"+i);
//                if (i==2){
//                    return;
//                }
//                System.out.println("return测试后i的值是"+i);
//            }


//            for (int i = 0; i < 3; i++) {
//                System.out.println("i的值是"+i);
//                if (i==2){
//                    break;
//                }
//                System.out.println("break测试后i的值是"+i);
//            }


            for (int i = 0; i < 3; i++) {
                System.out.println("i的值是"+i);
                if (1==2){
                    continue;
                }
                System.out.println("continue测试后i的值是"+i);
            }


            /**
             * 总结：
             *  break与contiue都是用来控制循环结构的、主要是停止循环
             *  break跳出整个循环、continue仅仅跳出当层循环
             *  retrun 结束语句 结束该方法 ，循环自然结束了
             */
        }
}
