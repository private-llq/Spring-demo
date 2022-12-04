package com.mayikt.adapter;

import com.mayikt.adapter.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 余胜军
 * @ClassName ControllerAdapter
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface ControllerAdapter {
    /**
     * 判断具体controller 到底是什么类型 通过该类型 查找到具体的适配器
     *
     * @param controller
     * @return
     */
    boolean supports(Controller controller);

    /**
     * 走具体的handler  如果是在springmvc 获取请求参数 根据httprequest对象就可以获取
     *
     * @param controller
     */
    void handler(Controller controller);
}
