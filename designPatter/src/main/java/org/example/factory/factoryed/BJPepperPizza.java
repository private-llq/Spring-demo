package org.example.factory.factoryed;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的Pepper");
        System.out.println("  北京的Pepper 准备原材料");
    }
}
