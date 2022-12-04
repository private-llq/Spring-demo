package com.mayikt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName MayiktController
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
public class MayiktController {
    /**
     * 访问  mayikt
     *
     * @return
     */
    @RequestMapping("/v1/getMayikt")
    public String getMayikt1() {
        return "mayikt";
    }

    /**
     * 访问  mayikt
     *
     * @return
     */
    @RequestMapping("/v2/getMayikt")
    public String getMayikt2() {
        return "mayikt";
    }

}
