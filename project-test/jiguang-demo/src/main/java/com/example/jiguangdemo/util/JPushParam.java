package com.example.jiguangdemo.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuliangqi
 * @date 2023/5/5 17:49
 */
@Component
@Data
@ConfigurationProperties(prefix = "jpush")
public class JPushParam {
    private Boolean environment;
    private String appKey;
    private String masterSecret;
}
