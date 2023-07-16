package com.example.springredis.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.IdUtil;
import com.example.springredis.service.CaptchaBuilder;
import com.example.springredis.vo.CaptchaInfo;
import org.springframework.stereotype.Service;

@Service
public class MyCaptchaBuilder implements CaptchaBuilder {




    @Override
    public CaptchaInfo create() {
        CaptchaInfo captchaInfo = new CaptchaInfo();
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        //ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(115, 38, 4, 2);

        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(115,38,4,5) ;
        captcha.setGenerator(new RandomGenerator("0123456789ABCDEFGHJKLMNPQRSTUVWXYZ",4));
        ////将验证码转成base64
        //captchaInfo.setImage(captcha.getImageBase64());
        ////生成uuid
        //String uuid = IdUtil.randomUUID();
        //captchaInfo.setUuid(uuid);
        ////得到验证码的值
        //captchaInfo.setCode(captcha.getCode());
        //将存到缓存中，键值是UUID
        return captchaInfo;
    }

    @Override
    public String getKey(String uuid) {
        return "captcha:" + uuid;
    }
}
