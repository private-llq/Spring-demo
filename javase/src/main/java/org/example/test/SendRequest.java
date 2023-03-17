package org.example.test;

import lombok.Data;

@Data
public class SendRequest {
    private String ecName;		//集团客户名称
    private String apId;		//用户名
    private String secretKey;	        //密码
    private String mobiles;		//手机号码逗号分隔。(如“18137282928,18137282922,18137282923”)
    private String content;		//发送短信内容
    private String sign;		//网关签名编码，必填，签名编码在中国移动集团开通帐号后分配，可以在云MAS网页端管理子系统-SMS接口管理功能中下载。
    private String addSerial;	        //扩展码，根据向移动公司申请的通道填写，如果申请的精确匹配通道，则填写空字符串("")，否则添加移动公司允许的扩展码。
    private String mac;			//API输入参数签名结果，签名算法：将ecName，apId，secretKey，mobiles，content ，sign，addSerial按照顺序拼接，然后通过md5(32位小写)计算后得出的值。
}
