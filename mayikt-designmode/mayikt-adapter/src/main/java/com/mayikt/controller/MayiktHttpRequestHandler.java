package com.mayikt.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 余胜军
 * @ClassName MayiktHttpRequestHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component("/mayiktHttpRequestHandler")
public class MayiktHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter writer = httpServletResponse.getWriter();
        writer.print("mayiktHttpRequestHandler");
        writer.close();
    }
    /**
     *  查找controller 三种不同实现方式？
     */
}

