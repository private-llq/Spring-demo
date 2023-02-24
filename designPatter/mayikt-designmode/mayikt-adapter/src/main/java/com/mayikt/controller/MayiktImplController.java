package com.mayikt.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author 余胜军
 * @ClassName MayiktImplController
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component("/implController")
public class MayiktImplController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        writer.print("mayikt--MayiktImplController");
        writer.close();
        return null;
    }
}
