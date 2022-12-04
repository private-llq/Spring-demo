package com.mayikt.init;

import com.mayikt.observer.MsgObServer;
import com.mayikt.observer.ObServer;

import com.mayikt.observer.impl.MsgSubject;
import com.mayikt.utils.ReflexUtils;
import com.mayikt.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
@Slf4j
public class SpringBootInitialization implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("springboot启动完成....");
        /**
         * 1.当我们springboot项目启动完成之后，获取当前有哪些观察者？ MsgObServer 所有实现class
         * 2.在根据该class去ioc容器中查找到该bean对象 存入到 msg主题中;
         */
        Set<Class> interfaceImpls = ReflexUtils.getInterfaceImpls(MsgObServer.class);
        MsgSubject msgSubject = SpringUtils.getBean("msgSubject", MsgSubject.class);
        interfaceImpls.forEach((c) -> {
            MsgObServer msgObServer = (MsgObServer) SpringUtils.getBean(c);
            msgSubject.addObServer(msgObServer);
        });
    }


}