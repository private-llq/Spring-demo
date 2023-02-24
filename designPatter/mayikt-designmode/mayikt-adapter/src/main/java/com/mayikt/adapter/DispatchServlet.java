package com.mayikt.adapter;

import com.mayikt.adapter.controller.Controller;
import com.mayikt.adapter.controller.impl.ImplController;
import com.mayikt.adapter.impl.AnnotationControllerAdapter;
import com.mayikt.adapter.impl.ImplControllerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 余胜军
 * @ClassName DispatchServlet
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class DispatchServlet {
    /**
     * 添加每一种 方式实现的适配器
     */
    private List<ControllerAdapter> controllerAdapters = new ArrayList<>();

    public DispatchServlet() {
        controllerAdapters.add(new AnnotationControllerAdapter());
        controllerAdapters.add(new ImplControllerAdapter());
    }

    public void doDispatch(Controller controller) {
        // 用户发送请求路径//restController 具体哪一种 controller实现方式
        ControllerAdapter controllerAdapter = getControllerAdapter(controller);
        controllerAdapter.handler(controller);
    }

    // 获取到该controller具体适配器
    public ControllerAdapter getControllerAdapter(Controller controller) {
        for (ControllerAdapter controllerAdapter :
                controllerAdapters) {
            // 判断该controller是否是为该类型 如果是则返回true
            if (controllerAdapter.supports(controller)) {
                return controllerAdapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch(new ImplController());
    }
}
