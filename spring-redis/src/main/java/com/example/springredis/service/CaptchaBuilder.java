package com.example.springredis.service;

import com.example.springredis.vo.CaptchaInfo;

public interface CaptchaBuilder {

    CaptchaInfo create();

    String getKey(String uuid);
}
