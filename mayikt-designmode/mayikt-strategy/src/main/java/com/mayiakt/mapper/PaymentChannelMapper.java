package com.mayiakt.mapper;

import com.mayiakt.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Select;

public interface PaymentChannelMapper {
    @Select("\n" +
            "SELECT  id as id ,CHANNEL_NAME as CHANNELNAME ,CHANNEL_ID as CHANNELID,strategy_bean_id AS strategybeanid\n" +
            " , is_delete as isDelete,create_time as createTime ,update_Time as updateTime  FROM payment_channel where CHANNEL_ID=#{payCode} and is_delete=0")
    PaymentChannelEntity getPaymentChannel(String payCode);
}