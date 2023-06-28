package org.example.library;

import java.util.ArrayList;

//泛型

public class BookList {


    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList() {
        books.add(new Book("活着", "余华", 35, "小说",20));
        books.add(new Book("冬泳", "今敏", 25, "小说",25));
        books.add(new Book("解忧杂货铺", "东野圭吾", 45, "小说",15));
        books.add(new Book("爆笑西游", "阿呆", 15, "小说",10));
    }


    public Book getBook(int pos) {
        return books.get(pos);
    }


    public void setBook(int pos, Book book) {
        books.set(pos, book);
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

}
