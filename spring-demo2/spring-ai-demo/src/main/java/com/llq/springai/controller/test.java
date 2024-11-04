package com.llq.springai.controller;
 
 
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.llq.springai.util.ApiTestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://127.0.0.1:5500") // 假设前端在3000端口运行
@RequestMapping("/api/v1/")
public class test {
    @PostMapping("/chattest")
    public Response test(@RequestParam(value = "message") String message){
        if(message.length() == 0 && Objects.isNull(message)){
            return new Response("-1","请输入问题",null);
        }
        String result = null;
        try {
            result = ApiTestUtil.getProblem(message);
        } catch (NoApiKeyException e) {
            log.error("apiKey错误");
        } catch (InputRequiredException e) {
            log.error("输入为空");
        }
        return new Response("0","success",result);
    }
}