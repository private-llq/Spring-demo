package org.example.springdemo.model;

import java.io.Serializable;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/26 11:03
 * @description: 实体类员工对象
 */
public class EmpEntity implements Serializable {
    private String name;
    private Integer age;
    private String address;

    public String getAddress() {
        return address;
    }

    public EmpEntity() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DeptEntity getDeptEntity() {
        return deptEntity;
    }

    /**
     * 员工属于那个部门
     */
    private  DeptEntity deptEntity;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public  void deptEntity(){

    }
    public void setDeptEntity(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }
    @Override
    public String toString() {
        return "EmpEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", deptEntity=" + deptEntity +
                '}';
    }

}
