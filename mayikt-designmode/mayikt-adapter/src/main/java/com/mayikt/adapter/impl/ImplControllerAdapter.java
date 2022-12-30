package com.mayikt.adapter.impl;

import com.mayikt.adapter.ControllerAdapter;
import com.mayikt.adapter.controller.Controller;
import com.mayikt.adapter.controller.impl.ImplController;

/**
 * @author 余胜军
 * @ClassName ControllerAdapter1
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ImplControllerAdapter implements ControllerAdapter {
    @Override
    public boolean supports(Controller controller) {
        return controller instanceof ImplController;
    }

    @Override
    public void handler(Controller controller) {
        ImplController implController = (ImplController) controller;
        implController.handleRequest();
    }
}
