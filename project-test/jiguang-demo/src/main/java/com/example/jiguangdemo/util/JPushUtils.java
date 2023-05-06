package com.example.jiguangdemo.util;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * [ 推送工具类 ]
 *
 * @author Love丶TG
 * @version 1.0.0
 * @create 2020 年 03 月 25 日 10:18
 */
@Slf4j
@Component
public class JPushUtils {

    @Autowired
    private JPushParam jPush;

    public static JPushUtils jPushUtils;

    @PostConstruct
    public void init() {
        jPushUtils = this;
    }

    /**
     * 获取JPushClient实例
     *
     * @return
     */
    private static JPushClient getJPushClient() {
        JPushClient jPushClient = new JPushClient(jPushUtils.jPush.getMasterSecret(), jPushUtils.jPush.getAppKey());
        return jPushClient;
    }

    /**
     * 发送给所有用户
     *
     * @param notification_title 通知内容标题
     * @param msg_title          消息内容标题
     * @param msg_content        消息内容
     * @param extrasparam        扩展字段
     * @return false推送失败，true推送成功
     */
    public static boolean sendToAll(String notification_title, String msg_title, String msg_content, String extrasparam) {
        boolean result = false;
        try {
            PushPayload pushPayload = PushPayload.newBuilder()
                    .setPlatform(Platform.android_ios())
                    .setAudience(Audience.all())
                    // .setAudience(Audience.alias(alias))     // List<String> alias 设备标识
                    .setNotification(Notification.newBuilder()
                            .setAlert(msg_content)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setAlert(msg_content)
                                    .setTitle(notification_title)
                                    //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                    .addExtra("url", extrasparam)
                                    .build()
                            )
                            .addPlatformNotification(IosNotification.newBuilder()
                                    //传一个IosAlert对象，指定apns title、title、subtitle等
                                    .setAlert(msg_content)
                                    //直接传alert
                                    //此项是指定此推送的badge自动加1
                                    .incrBadge(1)
                                    //此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
                                    // 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
                                    .setSound("sound.caf")
                                    //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                    .addExtra("url", extrasparam)
                                    //此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
                                    // .setContentAvailable(true)

                                    .build()
                            )
                            .build()
                    )
                    //Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。 jpush的自定义消息，
                    // sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
                    // [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msg_content)
                            .setTitle(msg_title)
                            .addExtra("url", extrasparam)
                            .build())

                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(jPushUtils.jPush.getEnvironment())
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build()
                    )
                    .build();
            PushResult pushResult = getJPushClient().sendPush(pushPayload);
            if (pushResult.getResponseCode() == 200) {
                result = true;
            }
            log.info("[极光推送]PushResult result is " + pushResult);
        } catch (APIConnectionException e) {
            log.error("[极光推送]Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("[极光推送]Error response from JPush server. Should review and fix it. ", e);
            log.info("[极光推送]HTTP Status: " + e.getStatus());
            log.info("[极光推送]Error Code: " + e.getErrorCode());
            log.info("[极光推送]Error Message: " + e.getErrorMessage());
        }

        return result;
    }

    /**
     * 发送给所有安卓用户
     *
     * @param notification_title 通知内容标题
     * @param msg_title          消息内容标题
     * @param msg_content        消息内容
     * @param extrasparam        扩展字段
     * @return false推送失败，true推送成功
     */
    public static boolean sendToAllAndroid(String notification_title, String msg_title, String msg_content, String extrasparam) {
        boolean result = false;
        try {
            // （透传消息android 也不用传Notification）
            PushPayload pushPayload = PushPayload.newBuilder()
                    //指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
                    .setPlatform(Platform.android())
                    //指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration id
                    .setAudience(Audience.all())
                    // .setAudience(Audience.registrationId(notice.getRegistrationId()))
                    //jpush的通知，android的由jpush直接下发，iOS的由apns服务器下发，Winphone的由mpns下发
                    .setNotification(Notification.newBuilder()
                            //指定当前推送的android通知
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setAlert(msg_content)
                                    .setTitle(notification_title)
                                    //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                    .addExtra("url", extrasparam)
                                    .build())
                            .build()
                    )
                    //Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。 jpush的自定义消息，
                    // sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
                    // [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msg_content)
                            .setTitle(msg_title)
                            .addExtra("url", extrasparam)
                            .build())

                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(jPushUtils.jPush.getEnvironment())
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();
            PushResult pushResult = getJPushClient().sendPush(pushPayload);
            if (pushResult.getResponseCode() == 200) {
                result = true;
            }
            log.info("[极光推送]PushResult result is " + pushResult);
        } catch (APIConnectionException e) {
            log.error("[极光推送]Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("[极光推送]Error response from JPush server. Should review and fix it. ", e);
            log.info("[极光推送]HTTP Status: " + e.getStatus());
            log.info("[极光推送]Error Code: " + e.getErrorCode());
            log.info("[极光推送]Error Message: " + e.getErrorMessage());
        }

        return result;
    }

    /**
     * 发送给所有IOS用户
     *
     * @param notification_title 通知内容标题
     * @param msg_title          消息内容标题
     * @param msg_content        消息内容
     * @param extrasparam        扩展字段
     * @return false推送失败，true推送成功
     */
    public static boolean sendToAllIos(String notification_title, String msg_title, String msg_content, String extrasparam) {
        boolean result = false;
        try {
            // IosNotification.Builder builder = IosNotification.newBuilder()
            //         .setAlert(IosAlert.newBuilder().setTitleAndBody(msg_title, null, msg_content).build())
            //         .addExtras(extrasparam);
            //  if (!JpushNotice.PASSTHROUGH.equals(notice.getContentType())) {
            //     builder = builder.incrBadge(1);
            // }
            //（透传消息ios不用配置setNotification属性）
            PushPayload pushPayload = PushPayload.newBuilder()
                    //指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
                    .setPlatform(Platform.ios())
                    //指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration id
                    .setAudience(Audience.all())
                    // .setAudience(Audience.registrationId(notice.getRegistrationId()))
                    //jpush的通知，android的由jpush直接下发，iOS的由apns服务器下发，Winphone的由mpns下发
                    .setNotification(Notification.newBuilder()
                            //指定当前推送的android通知
                            // .addPlatformNotification(builder.build()).build())
                            .addPlatformNotification(IosNotification.newBuilder()
                                    //传一个IosAlert对象，指定apns title、title、subtitle等
                                    .setAlert(msg_content)
                                    //直接传alert
                                    //此项是指定此推送的badge自动加1
                                    .incrBadge(1)
                                    // .setBadge(+1)
                                    //此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
                                    // 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
                                    .setSound("sound.caf")
                                    // .setSound("happy")
                                    //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                    .addExtra("url", extrasparam)
                                    //此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
                                    // .setContentAvailable(true)

                                    .build())
                            .build()
                    )
                    //Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。 jpush的自定义消息，
                    // sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
                    // [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msg_content)
                            .setTitle(msg_title)
                            .addExtra("url", extrasparam)
                            .build())

                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(jPushUtils.jPush.getEnvironment())
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();
            PushResult pushResult = getJPushClient().sendPush(pushPayload);
            if (pushResult.getResponseCode() == 200) {
                result = true;
            }
            log.info("[极光推送]PushResult result is " + pushResult);
        } catch (APIConnectionException e) {
            log.error("[极光推送]Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("[极光推送]Error response from JPush server. Should review and fix it. ", e);
            log.info("[极光推送]HTTP Status: " + e.getStatus());
            log.info("[极光推送]Error Code: " + e.getErrorCode());
            log.info("[极光推送]Error Message: " + e.getErrorMessage());
        }

        return result;
    }

    public static void main(String[] args) {
        PushVO pushVO = new PushVO();
        pushVO.setId(1L);
        pushVO.setUsername("llq");
        pushVO.setContent("我是liuliangqi");
        System.err.println(JPushUtils.sendToAllAndroid("通知标题", "消息标题", "通知|消息内容", JSON.toJSONString(pushVO)));

    }

}
