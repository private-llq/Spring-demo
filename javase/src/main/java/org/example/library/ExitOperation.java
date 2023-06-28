package org.example.library;

import java.util.Scanner;


public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) throws OperationException {
        System.out.println("是否要进行退出?" + "(Y/N)");
        Scanner scan = new Scanner(System.in);

        if (scan.next().equalsIgnoreCase("Y")) {
            System.out.println("退出成功!");
            System.exit(0);
        }

    }

}
