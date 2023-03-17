package org.example.springdemo.model;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/26 11:03
 * @description: 部门对象
 */
public class DeptEntity {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public DeptEntity() {
    }

    @Override
    public String toString() {
        return "DeptEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
