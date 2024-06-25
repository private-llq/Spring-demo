package org.example.factory;

import java.util.Collections;

/**
 * @program: spring-demo
 * @description: 看一个披萨的项目：要便于披萨种类的扩展，要便于维护。
 * 披萨的种类很多（比如GreekPizza、CheesePizza等）；
 * 披萨的制作有prepare，bake，cut，box；
 * 完成披萨店订购功能。 图片如图:img
 * @author: liulq
 * @create: 2022-10-02 15:41
 */
//把Pizza类做成抽象类
public abstract class Pizza {
    private String name;//名字

    //准备原材料，不同的披萨不一样，因此，我们做成抽象方法
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " 烘焙baking");
    }

    public void cut() {
        System.out.println(name + " 切割cutting");
    }

    public void box() {
        System.out.println(name + " 拳击boxing");
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Collections.sort(list,c);
    }
}
