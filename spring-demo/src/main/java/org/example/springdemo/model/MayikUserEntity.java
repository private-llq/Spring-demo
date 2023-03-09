package org.example.springdemo.model;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/27 11:47
 * @description: 公司
 */
public class MayikUserEntity {
    private String username;
    private Integer age;
    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MayikUserEntity() {
        System.out.println("无参构造初始化....");
    }

    public MayikUserEntity(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MayikUserEntity{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
