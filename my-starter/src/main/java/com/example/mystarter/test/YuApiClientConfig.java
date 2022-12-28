package com.example.mystarter.test;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.mystarter.test
 * @date 2022/12/21 21:47
 * @description: 公司
 */
public class YuApiClientConfig {

    /**
     * appId
     */
    private String appId;

    /**
     * 秘钥
     */
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public YuApiClientConfig() {
    }

    public YuApiClientConfig(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        return "YuApiClientConfig{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}
