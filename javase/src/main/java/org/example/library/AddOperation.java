package org.example.library;

import java.util.Scanner;


public class AddOperation implements IOperation {

    @Override
    public void work(BookList bookList) {

        System.out.println("新增图书!");
        Scanner scan=new Scanner(System.in);


        System.out.println("请输入要新增图书的名字:");
        String name=scan.next();
        System.out.println("请输入作者的名字:");
        String author=scan.next();
        System.out.println("请输入图书的价格:");
        int price=scan.nextInt();
        System.out.println("请输入图书的类型:");
        String type=scan.next();
        System.out.println("请输入图书的库存:");
        int stock = scan.nextInt();;

        Book book=new Book(name,author,price,type,stock);


        bookList.getBooks().add(book);


        System.out.println("完成添加");
    }

}
