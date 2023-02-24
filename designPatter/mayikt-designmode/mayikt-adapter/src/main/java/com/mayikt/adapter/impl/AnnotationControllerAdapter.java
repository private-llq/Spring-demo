package com.mayikt.adapter.impl;

import com.mayikt.adapter.ControllerAdapter;
import com.mayikt.adapter.controller.Controller;
import com.mayikt.adapter.controller.impl.AnnotationController;

/**
 * @author 余胜军
 * @ClassName ControllerAdapter1
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class AnnotationControllerAdapter implements ControllerAdapter {
    @Override
    public boolean supports(Controller controller) {
        return controller instanceof AnnotationController;
    }

    @Override
    public void handler(Controller controller) {
        AnnotationController annotationController = (AnnotationController) controller;
        annotationController.requestMapping();
    }
}
