package org.example.library;

public class AdminUser extends User {
    public AdminUser(String name){
        super(name);
    }

    public void menu(){
        System.out.println("==================================");
        System.out.println("欢迎 "+this.getName()+"来到图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书 ");
        System.out.println("3.下架图书 ");
        System.out.println("4.显示图书 ");
        System.out.println("0.退出系统 ");
        System.out.println("==================================");
    }


    public  void Operation(int n, BookList bookList)throws OperationException {
        IOperation iOperation=null;
        switch(n){
            case 0:
                iOperation= new ExitOperation();
                break;
            case 1:
                iOperation= new FindOperation();
                break;
            case 2:
                iOperation= new AddOperation();
                break;
            case 3:
                iOperation= new Deloperation();
                break;
            case 4:
                iOperation= new DisplayOperation();
                break;
            default:
                throw new OperationException("输入错误，请重新输入！");
        }
















        try {
            iOperation.work(bookList);
        }catch(OperationException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
