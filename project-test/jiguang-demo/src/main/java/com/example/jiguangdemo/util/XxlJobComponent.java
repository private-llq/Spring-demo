package com.example.jiguangdemo.util;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.util.XxlJobRemotingUtil;

public class XxlJobComponent {

    private String addressUrl;

    private String accessToken;

    private String appName;

    private int timeout;

    private static final int SUCCESS_CODE = 200;

    private static final String URL_SEPARATION = "/";

    public XxlJobComponent(String addressUrl, String accessToken, String appName, int timeout) {
        this.addressUrl = addressUrl;
        this.accessToken = accessToken;
        if (!this.addressUrl.endsWith(URL_SEPARATION)) {
            this.addressUrl = this.addressUrl + URL_SEPARATION;
        }
        this.appName = appName;
        this.timeout = timeout;
    }

    /**
     * 新增任务
     *
     * @param jobDesc    任务描述
     * @param cron       cron表达式
     */
    public boolean addJob(String jobDesc, String cron, String param, String jobHandler) {
        XxlJobInfo jobInfo = buildJobInfo(null, jobDesc, cron, param, jobHandler);
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/add", this.accessToken, this.timeout, jobInfo, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("add_job_error");
        }
        int jobId = Integer.parseInt(result.getContent());
        return jobId != 0;
    }

    /**
     * 更新任务
     *
     * @param jobId      任务id
     * @param jobDesc    任务描述
     * @param cron       cron表达式
     */
    public void updateJob(Integer jobId, String jobDesc, String cron, String param, String jobHandler) {
        XxlJobInfo jobInfo = buildJobInfo(jobId, jobDesc, cron, param, jobHandler);
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/update", this.accessToken, this.timeout, jobInfo, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("update_job_error");
        }
    }

    /**
     * 删除任务
     */
    public void removeJob(Integer jobId) {
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/remove", this.accessToken, this.timeout, jobId, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("remove_job_error");
        }
    }

    /**
     * 开始任务
     *
     */
    public void startJob(Integer jobId) {
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/start", this.accessToken, this.timeout, jobId, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("start_job_error");
        }
    }

    /**
     * 停止任务
     *
     * @param jobId 资源id
     */
    public void stopJob(Integer jobId) {
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/stop", this.accessToken, this.timeout, jobId, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("stop_job_error");
        }
    }

    /**
     * 触发任务
     *
     * @param jobId 资源id
     */
    public void triggerJob(Integer jobId) {
        ReturnT<String> result = XxlJobRemotingUtil.postBody(addressUrl + "jobinfo/api/trigger", this.accessToken, this.timeout, jobId, String.class);
        if (result.getCode() != SUCCESS_CODE) {
            throw new IllegalArgumentException("trigger_job_error");
        }
    }

    private XxlJobInfo buildJobInfo(Integer id, String jobDesc, String cron, String param, String jobHandler) {
        XxlJobInfo jobInfo = new XxlJobInfo();
        if (id != null) {
            jobInfo.setId(id);
        }
        jobInfo.setAppName(appName);
        jobInfo.setJobDesc(jobDesc);
        jobInfo.setAuthor("llq");
        jobInfo.setScheduleType("CRON");
        jobInfo.setScheduleConf(cron);
        jobInfo.setExecutorRouteStrategy("ROUND");
        jobInfo.setMisfireStrategy("DO_NOTHING");
        jobInfo.setGlueType("BEAN");
        jobInfo.setExecutorHandler(jobHandler);
        jobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        jobInfo.setExecutorParam(param);
        return jobInfo;
    }
}