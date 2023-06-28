package org.example.library;

public class NormalUser extends User {
    public NormalUser(String name){
        super(name);
    }
    @Override
    public void menu() {

        //图书管理系统读者登录界面
        System.out.println("欢迎"+this.getName()+"来到图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
    }



    //对读者的操作选项进行识别
    public void Operation(int n, BookList bookList)throws OperationException {
        IOperation iOperation=null;
        switch(n){
            case 0:
                iOperation= new ExitOperation();
                break;
            case 1:
                iOperation=new FindOperation();
                break;
            case 2:
                iOperation=new BorrowOperation();
                break;
            case 3:
                iOperation=new ReturnOperation();
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
