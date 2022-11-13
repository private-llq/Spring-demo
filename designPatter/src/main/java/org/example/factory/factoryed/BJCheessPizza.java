package org.example.factory.factoryed;

public class BJCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的CheessPizza");
        System.out.println("  北京的CheessPizza 准备原材料");
    }
}
