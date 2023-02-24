package com.mayikt.service.entity;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author 余胜军
 * @ClassName MsgEntity
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Data
public class MsgEntity  extends ApplicationEvent {
    // 手机号码
    private String phone;
    // 邮件
    private String email;
    // 微信openid
    private String weChatOpenId;
    /**
     * 钉钉openid
     */
    private String dindinOpenId;

    public MsgEntity(Object source, String phone, String email, String weChatOpenId, String dindinOpenId) {
        super(source);
        this.phone = phone;
        this.email = email;
        this.weChatOpenId = weChatOpenId;
        this.dindinOpenId = dindinOpenId;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", weChatOpenId='" + weChatOpenId + '\'' +
                ", dindinOpenId='" + dindinOpenId + '\'' +
                '}';
    }
}
