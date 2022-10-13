package com.example.springimport.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 杜飘
 * @date 2022/9/30
 */
@Data
public class RfServiceExcel {

    /**
     * 序号
     */
    private Integer number;

    /**
     * 产品类型
     */
    private Integer category;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编码
     */
    private Integer type;

    /**
     * 版本号
     */
    private String version;

    /**
     * Logo
     */
    private Long logoFileId;

    /**
     * 产品简介
     */
    private String introduction;

    /**
     * 产品介绍
     */
    private String description;

    /**
     * 产品发布时间
     */
    private Date releaseTime;

    /**
     * 授权代码
     */
    private String authCode;

    /**
     * 镜像名称、版本号
     */
    private String image;

}
