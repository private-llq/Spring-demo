package org.example.library;

public class Book {
    private String name;
    private String author;
    private int price;
    private String type;
    private int stock;  //加了个库存



    public Book(){

    }
    public Book(String name,String author,int price,String type,int isBorrowed){
        this.name=name;
        this.author=author;
        this.price=price;
        this.type=type;
        this.stock=isBorrowed;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int isBorrowed() {
        return stock;
    }


    public void setBorrowed(int isBorrowed) {
        this.stock = isBorrowed;
    }

    public int getCount() {

        return stock;
    }
    public void borrow() {
        stock--;

    }
    public void ret() {
        stock++;

    }

    public String toString() {
        return "\n书籍信息{" +
                "书名:'" + name + '\'' +
                ", 作者:'" + author + '\'' +
                ", 价格:" + price +
                ", 类型:'" + type + '\'' +
                ", 库存:" + stock +
                "}";
    }

}
