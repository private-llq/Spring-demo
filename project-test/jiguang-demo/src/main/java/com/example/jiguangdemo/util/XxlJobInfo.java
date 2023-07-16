package com.example.jiguangdemo.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class XxlJobInfo {

    /**
     * 主键ID
     */
    private int id;

    /**
     * appname用来获取jobGroup
     */
    private String appName;

    /**
     * 执行器主键ID
     */
    private int jobGroup;

    /**
     * 任务描述
     */
    private String jobDesc;

    /**
     * 负责人
     */
    private String author;

    /**
     * 报警邮箱
     */
    private String alarmEmail;

    /**
     * 调度类型（CRON）
     */
    private String scheduleType;

    /**
     * 调度配置，值含义取决于调度类型
     */
    private String scheduleConf;

    /**
     * 调度过期策略
     */
    private String misfireStrategy;

    /**
     * 执行器路由策略
     */
    private String executorRouteStrategy;


    /**
     * 执行器，任务参数
     */
    private String executorParam;

    /**
     * 阻塞处理策略
     */
    private String executorBlockStrategy;

    /**
     * 任务执行超时时间，单位秒
     */
    private int executorTimeout;

    /**
     * 失败重试次数
     */
    private int executorFailRetryCount;

    /**
     * GLUE类型	#com.xxl.job.core.glue.GlueTypeEnum,一般为BEAN
     */
    private String glueType;

    /**
     * 执行器，任务Handler名称
     */
    private String executorHandler;

    /**
     * GLUE源代码
     */
    private String glueSource;

    /**
     * GLUE备注
     */
    private String glueRemark;


}