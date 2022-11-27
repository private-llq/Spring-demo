package org.example.springdemo.model;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/26 22:32
 * @description: 公司
 */
public class MemberEntity {
    private String name;
    public void setName(String name){
        System.out.println("【第二步流程：】执行MerberEntity无产构造");
        this.name = name;
    }

    public MemberEntity() {
        System.out.println("【第一步流程:】执行setName方法");
    }

    public void init(){
        System.out.println("【第三步流程：】调用");
    }

    public void destroy(){
        System.out.println("【第五步步流程：】调用init方法");
    }
}
