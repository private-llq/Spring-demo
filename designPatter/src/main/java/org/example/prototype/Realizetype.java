package org.example.prototype;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.prototype
 * @date 2022/11/14 16:07
 * @description: 原型类 浅克隆
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}
