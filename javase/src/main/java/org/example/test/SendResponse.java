package org.example.test;

import lombok.Data;

@Data
public class SendResponse {
    private String rspcod;	//响应状态码
    private String msgGroup;	//消息批次号，由云MAS平台生成，用于验证短信提交报告和状态报告的一致性（取值msgGroup）注:如果数据验证不通过msgGroup为空
    private boolean success;	//数据校验结果
}
