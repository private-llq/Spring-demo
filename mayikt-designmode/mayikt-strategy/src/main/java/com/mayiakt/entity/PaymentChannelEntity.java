package com.mayiakt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentChannelEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 策略执行beanId
     */
    private String strategyBeanId;
    private Integer is_delete;
    private Date createDate;
    private Date updateDate;

}