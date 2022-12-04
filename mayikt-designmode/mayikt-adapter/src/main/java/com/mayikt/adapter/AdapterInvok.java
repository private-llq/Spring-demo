package com.mayikt.adapter;

import com.mayikt.adapter.controller.impl.AnnotationController;
import com.mayikt.adapter.controller.impl.ImplController;
import com.mayikt.adapter.controller.impl.RequestHandlerController;

/**
 * @author 余胜军
 * @ClassName AdapterInvok
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class AdapterInvok {
    public static void invok(Object controller) {
        // 判断该类型是否为AnnotationController 让后强转 才可以调用具体方法
        if (controller instanceof AnnotationController) {
            AnnotationController annotationController = (AnnotationController) controller;
            annotationController.requestMapping();
            return;
        }
        if (controller instanceof ImplController) {
            ImplController implController = (ImplController) controller;
            implController.handleRequest();
        }
        if (controller instanceof RequestHandlerController) {
            RequestHandlerController requestHandlerController = (RequestHandlerController) controller;
            requestHandlerController.requestHandler();
        }
        // 新增了第四种方式
        if (controller instanceof RequestHandlerController) {
            RequestHandlerController requestHandlerController = (RequestHandlerController) controller;
            requestHandlerController.requestHandler();
        }

    }

    public static void main(String[] args) {
        AdapterInvok.invok(new AnnotationController());
    }
}
