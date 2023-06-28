package org.example.library;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) throws Exception {
        Scanner scan=new Scanner(System.in);
        System.out.println("请您输入要归还的书籍名:");
        String name=scan.next();
        boolean flag=true;
        for(int i=0;i<bookList.getBooks().size();i++){
            if(bookList.getBooks().get(i).getName().equals(name)){
                flag=false;
                System.out.println("归还成功!");
                bookList.getBooks().get(i).ret();
            }
        }
        if(flag){
            throw new OperationException("无法查询到此书!");
        }
    }

}
