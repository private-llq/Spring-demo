package org.example.library;

import java.util.Arrays;
import java.util.Scanner;


public class BorrowOperation implements IOperation {

    public void work(BookList bookList) throws OperationException {
        System.out.println(bookList.getBooks());
        System.out.println("请输入你想要借的书:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        boolean flag = true;

        final int MAX_BOOKS = 100; // 最大书籍数量限制
        Book[] borrowedBooks = new Book[MAX_BOOKS]; // 存放用户借阅书籍信息的数组

        for (int i = 0; i < bookList.getBooks().size(); i++) {
            if (bookList.getBooks().get(i).getName().equals(name)) {
                flag = false;


                if (bookList.getBooks().get(i).getCount() == 0) {
                    throw new OperationException("借阅失败，该书已被借出");
                } else {
                    System.out.println("借阅成功!");
                    bookList.getBooks().get(i).borrow();
                }


            }
        }
        if (flag) {
            throw new OperationException("未查找到该书");
        }
    }

}
