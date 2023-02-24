package com.mayikt.adapter.controller.impl;

import com.mayikt.adapter.controller.Controller;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName AnnotationController
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class AnnotationController implements Controller {

    public void requestMapping() {
        log.info("<通过注解的形式 实现Controller>");
    }

}
