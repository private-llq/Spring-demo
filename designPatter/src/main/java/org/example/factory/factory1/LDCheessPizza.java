package org.example.factory.factory1;

public class LDCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的CheessPizza");
        System.out.println("  伦敦的CheessPizza 准备原材料");
    }
}
