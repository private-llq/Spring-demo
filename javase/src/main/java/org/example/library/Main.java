package org.example.library;

import java.util.Scanner;

public class   Main {
    public static void main(String[] args) {

        System.out.println("=======欢迎使用图书管理系统=======");
        System.out.println("请输入您的身份: ");
        System.out.println("0.管理员");
        System.out.println("1.用户 ");
        System.out.println("==================================");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        System.out.println("请输入你的姓名:");
        User user = null;
        BookList bookList = new BookList();

        switch (choice) {
            case 0:
                user = new AdminUser(scan.next());
                break;
            case 1:
                user = new NormalUser(scan.next());
                break;
        }

        IOperation iOperatiOn = null;
        do {
            user.menu();
            System.out.println("请选择操作数:");
            int input = scan.nextInt();
            if (input == 0) {
                System.out.println("退出成功");
                return;
            }
            try {
                user.Operation(input, bookList);
            } catch (OperationException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

}
