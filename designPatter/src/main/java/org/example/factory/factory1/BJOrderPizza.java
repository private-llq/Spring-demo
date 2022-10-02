package org.example.factory.factory1;

public class BJOrderPizza  extends OrderPizza {
    @Override
    Pizza creatPizza(String orderType) {
        Pizza pizza=null;
        if (orderType.equals("Cheess")){
            pizza=new BJCheessPizza();
        }else if(orderType.equals("Pepper")){
            pizza=new BJPepperPizza();
        }
        return pizza;
    }
}
