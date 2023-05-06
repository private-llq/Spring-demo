package com.example.jiguangdemo.util;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.report.MessageStatus;
import cn.jpush.api.report.model.CheckMessagePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JPushUtil {

    private static String appKey = "4ea818dafa7fc9cb9cb5f3c5";

    private static String masterSecret = "1d5fe0c657270faa0697c04d";

    private static boolean apnsProduction = true;

    private static long jpushTime = 86400L;
    private static JPushClient jPushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());

    private static final int RESPONSE_OK = 200;
    private static final Logger logger = LoggerFactory.getLogger(JPushUtils.class);


    public static void main(String[] args) {
        PushPayload androidNotificationAll = createAndroidNotificationAll("测试 测试", "极光推送测试", null);
        PushResult pushResult = sendPush(androidNotificationAll);
        System.out.println("pushResult = " + pushResult);
    }


    /****************************************************************************************************************************/
    /******************           以下是直接获取pushPayload  自己获取之后再推送                                   *******************/
    /****************************************************************************************************************************/
    /**
     * @Method 设置推送对象PushPayload
     * @Author MC
     * aliasList:设备唯一识别码集合
     * msgTitle:推送标题
     * msgContent:推送内容
     * parm:扩展参数
     * @Return
     * @Date 2019/8/20 0020 15:06
     */
    public static PushPayload setPushPayloadByRegId(List<String> aliasList, String msgTitle, String msgContent, Map<String, String> parm) {

        // 创建一个IosAlert对象，可指定APNs的alert、title等字段
        // IosAlert iosAlert =  IosAlert.newBuilder().setTitleAndBody("title", "alert body").build();

        return PushPayload.newBuilder()
                // 指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
                .setPlatform(Platform.all())
                // 指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration id
                //                .setAudience(Audience.alias(aliasList))这个是通过别名
                .setAudience(Audience.registrationId(aliasList))//通过设备唯一识别码进行推送
                // jpush的通知，android的由jpush直接下发，iOS的由apns服务器下发，Winphone的由mpns下发
                .setNotification(Notification.newBuilder()
                        // 指定当前推送的android通知
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(msgContent)
                                .setTitle(msgTitle)
                                // 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                .addExtras(parm)
                                .build())
                        // 指定当前推送的iOS通知
                        .addPlatformNotification(IosNotification.newBuilder()
                                // 传一个IosAlert对象，指定apns title、title、subtitle等
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(msgTitle, "", msgContent)
                                        .build())
                                // 直接传alert
                                // 此项是指定此推送的badge自动加1
                                .incrBadge(1)
                                // 此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
                                // 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
                                .setSound("default")
                                // 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                .addExtras(parm)
                                // 此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
                                // 取消此注释，消息推送时ios将无法在锁屏情况接收
                                // .setContentAvailable(true)
                                .build())
                        .build())
                // Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。 jpush的自定义消息，
                // sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
                // [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
                .setMessage(Message.newBuilder()
                        .setMsgContent(msgContent)
                        .setTitle(msgTitle)
                        .addExtras(parm)
                        .build())
                .setOptions(Options.newBuilder()
                        // 此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                        .setApnsProduction(apnsProduction)
                        // 此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                        .setSendno(1)
                        // 此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天；
                        .setTimeToLive(jpushTime)
                        .build())
                .build();

    }

    /**
     * 对所有平台所有设备上的进行推送通知
     *
     * @param alert 发送的通知
     */
    public static PushPayload createAllNotificationAll(String title, String alert)
            throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 多个标签取交集的用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createAllNotificationWithTagsAnd(String title, String alert, Collection<String> tags, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag_and(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 多个标签取并集的用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createAllNotificationWithTagsOr(String title, String alert, Collection<String> tags, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 注册id用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param registrationIds
     * @param extras
     */
    public static PushPayload createAllNotificationWithRegistrationIds(String title, String alert, Collection<String> registrationIds, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationIds))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 多个标签取交集的用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param alias
     * @param extras
     */
    public static PushPayload createAllNotificationWithAlias(String title, String alert, Collection<String> alias, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 别名用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param alias
     * @param extras
     */
    public static PushPayload createAndroidNotificationWithAlias(String title, String alert, Collection<String> alias, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 ios 平台 别名用户发送通知  附带额外的参数信息extra
     *
     * @param alert
     * @param alias
     * @param extras
     */
    public static PushPayload createIosNotificationWithAlias(IosAlert alert, Collection<String> alias, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 ios 平台 别名用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createIosNotificationWithTagsAnd(String title, String alert, Collection<String> tags, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag_and(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 ios 平台 别名用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createIosNotificationWithTagsOr(String title, String alert, Collection<String> tags, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, "", alert)
                                        .build())
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 ios 平台 别名用户发送通知  附带额外的参数信息extra
     *
     * @param alert
     * @param registrationIds
     * @param extras
     */
    public static PushPayload createIosNotificationWithRegistrationIds(IosAlert alert, Collection<String> registrationIds, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId(registrationIds))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 给定标签交集用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createAndroidNotificationWithTagsAnd(String title, String alert, Collection<String> tags, Map<String, String> extras)
            throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag_and(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 给定标签并集用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createAndroidNotificationWithTagsOr(String title, String alert, Collection<String> tags, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .build())
                .build();
    }


    /**
     * desc  :向 别名用户发送通知  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param registrationIds
     * @param extras
     */
    public static PushPayload createAndroidNotificationWithRegistrationIds(String title, String alert, Collection<String> registrationIds, Map<String, String> extras) throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId(registrationIds))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .setTitle(title)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :生成向安卓所有用户推送的pushPayload通知
     *
     * @param title
     * @param content
     * @return
     */
    public static PushPayload createAndroidNotificationAll(String title, String content, Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(content)
                                .setTitle(title)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :生成向ios所有用户推送的pushPayload通知
     *
     * @return
     */
    public static PushPayload createIosNotificationAll(IosAlert alert, Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtras(extras)
                                .setAlert(alert)
                                .build())
                        .build())
                .build();
    }

    /**
     * desc  :向 多个标签取交集的用户发送Message  附带额外的参数信息extra
     *
     * @param title
     * @param alert
     * @param tags
     * @param extras
     */
    public static PushPayload createAllMessageWithTagsAnd(String title, String alert, Collection<String> tags, Map<String, String> extras)
            throws APIConnectionException, APIRequestException {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tags))
                .setMessage(Message.newBuilder()
                        .setMsgContent(alert)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .build();
    }


    /**
     * 发送
     */
    public static PushResult sendPush(PushPayload pushPayload) {
        logger.info("pushPayload={}", pushPayload);
        PushResult pushResult = null;
        try {
            pushResult = jPushClient.sendPush(pushPayload);
            logger.info("" + pushResult);
            if (pushResult.getResponseCode() == RESPONSE_OK) {
                logger.info("push successful, pushPayload={}", pushPayload);
            }
        } catch (APIConnectionException e) {
            logger.error("push failed: pushPayload={}, exception={}", pushPayload, e);
        } catch (APIRequestException e) {
            logger.error("push failed: pushPayload={}, exception={}", pushPayload, e);
        }

        return pushResult;
    }


    /**
     * desc  :送达状态查询  默认当天的推送
     *
     * @param ids 注册id的list集合
     * @return map   键是注册id   值是MessageStatus
     */
    public static Map<String, MessageStatus> getReceiveStatus(Long msgId, List<String> ids) throws APIConnectionException, APIRequestException {
        CheckMessagePayload build = CheckMessagePayload.newBuilder()
                .setMsgId(msgId)
                .setRegistrationsIds(ids)
                .build();
        return jPushClient.getMessageStatus(build);
    }

    /**
     * desc  :送达状态查询
     *
     * @param ids  注册id的list集合
     * @param date 指定日期   格式：yyyy-mm-dd
     * @return map   键是注册id   值是MessageStatus
     */
    public static Map<String, MessageStatus> getReceiveStatus(Long msgId, List<String> ids, String date) throws APIConnectionException, APIRequestException {
        CheckMessagePayload build = CheckMessagePayload.newBuilder()
                .setDate(date)
                .setMsgId(msgId)
                .setRegistrationsIds(ids)
                .build();
        return jPushClient.getMessageStatus(build);
    }


    /**
     * desc  :将拿到的新的注册id 设置别名和标签
     */
    public static boolean setAliasAndTag(String registrationId)
            throws APIConnectionException, APIRequestException {

        HashSet<String> add = new HashSet<>();

        jPushClient.updateDeviceTagAlias(registrationId, "", add, null);
        return true;
    }


    /**
     * 获取=某个注册id 的别名和标签
     */
    public static TagAliasResult getAliasAndTags(String registrationId) throws APIConnectionException, APIRequestException {
        return jPushClient.getDeviceTagAlias(registrationId);
    }

    /**
     * 绑定手机号
     *
     * @param registrationId
     * @param mobile
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static void bindMobile(String registrationId, String mobile) throws APIConnectionException, APIRequestException {
        jPushClient.bindMobile(registrationId, mobile);
    }

    /*public static void main(String[] args) throws APIConnectionException, APIRequestException {
        List<String> strings = Arrays.asList("11","22","33");//存放设备识别码
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("eee","eee");
        objectObjectHashMap.put("cc","eecce");
//        PushPayload payload = createAndroidNotificationWithRegistrationIds("这是标题", "这是内容测试长度==============================", strings, objectObjectHashMap);
        PushPayload payload = setPushPayloadByRegId(strings, "这是标题", "这是内容测试长度==============================", objectObjectHashMap);
//        PushPayload payload = createAllNotificationWithRegistrationIds("这是标题", "这是内容测试长度==============================", strings, objectObjectHashMap);
//        PushPayload payload = createAllNotificationAll("这是标题", "这是内容测试长度==============================");
        PushResult result = sendPush(payload);

        System.out.println(result.msg_id);
        System.out.println(result.sendno);
        System.out.println(result.statusCode);
        System.out.println(result.error);


    }*/


}
