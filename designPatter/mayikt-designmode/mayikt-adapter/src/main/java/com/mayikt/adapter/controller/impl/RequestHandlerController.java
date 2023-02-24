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
public class RequestHandlerController implements Controller {

    public void requestHandler() {
        log.info("<通过实现RequestHandlerController方式>");
    }

}
