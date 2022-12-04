package com.mayikt.service;

import com.mayikt.observer.impl.MsgSubject;
import com.mayikt.service.entity.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName MayiktService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
@Slf4j
public class MayiktService {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MsgSubject msgSubject;

    /**
     * 登录代码
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        log.info("login...");
        // 1.步骤1：验证数据库信息（手机号码、密码） //1
        // 2.步骤2: 发送登录短信、邮件、公众号模板、赠送优惠卷、发送钉钉
        // 发送短信、发送邮件、发送微信公众号
//        sendMsg(); // 1s
//        sendEmail(); // 1s
//        sendWechatTemplate(); // 1s
        //send发送优惠券
//        sendDinDin();
//        MsgEntity msgEntity =
//                new MsgEntity(this, "18140668851", "644064@qq.com",
//                        "wx123456", "dingding123456");
//        applicationContext.publishEvent(msgEntity);
        // 给我们的每个观察者发送内容
        msgSubject.notifyAllObServer("mayikt");
        return "ok";
    }
    /**
     * tomcat线程 并发量比较大的情况下 使用多线程方式异步 缺点:消耗cpu资源
     */

}
