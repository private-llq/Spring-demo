package com.mayikt.observer;

import com.mayikt.observer.impl.*;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {

    public static void main(String[] args) {
        //1.将观察者对象存入到集合中
        ObServer obServer1 = new TextMessageObServer();
        ObServer obServer2 = new WeChatObServer();
        ObServer obServer3 = new DinDinObServer();

        MsgSubject msgSubject = new MsgSubject();
        msgSubject.addObServer(obServer1);
        msgSubject.addObServer(obServer2);
        msgSubject.addObServer(obServer3);
        //2.通知给所有的观察者
        msgSubject.notifyAllObServer("['openId':'1','15921009843']");

        IntegralSubject integralSubject = new IntegralSubject();
        ObServer obServer4 = new IntegralObServer();
        integralSubject.addObServer(obServer4);
        integralSubject.notifyAllObServer("[userId:'1']");
        /**
         *         MsgEntity msgEntity =
         *                 new MsgEntity(this, "18140668851", "644064@qq.com",
         *                         "wx123456", "dingding123456");
         *         applicationContext.publishEvent(msgEntity);
         */
    }
}
