package org.example.factory.factoryed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BJCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的CheessPizza");
        System.out.println("  北京的CheessPizza 准备原材料");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("令狐冲");
        list.add("风清扬");
        list.add("任我行");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
//            String next = iterator.next();
            System.out.println(iterator.next());
        }
    }
}
