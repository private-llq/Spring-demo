package org.example.library;

import java.util.Scanner;


public class Deloperation implements IOperation {

    public void work(BookList bookList) throws OperationException {
        System.out.println("请输入你想要删除的书籍:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        boolean flag = true;


        for (int i = 0; i < bookList.getBooks().size(); i++) {
            if (bookList.getBooks().get(i).getName().equals(name)) {
                flag = false;
                System.out.println("查找到想要删除的书籍，请问是否要进行删除:" + name + "(Y/N)");


                if (scan.next().equalsIgnoreCase("y")) {
                    bookList.getBooks().remove(i);
                    System.out.println("删除成功!");
                }

            }
        }


        if (flag) {
            throw new OperationException("未查找到该书籍!");
        }

    }
}
