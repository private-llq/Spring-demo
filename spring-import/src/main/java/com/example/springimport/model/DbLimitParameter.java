//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springimport.model;

import javax.persistence.Transient;

public class DbLimitParameter {
    @Transient
    private Integer maxSize = 2000;

    public DbLimitParameter() {
    }

    public Integer getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
