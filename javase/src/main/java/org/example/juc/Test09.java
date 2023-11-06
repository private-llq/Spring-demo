package org.example.juc;

import cn.hutool.core.net.url.UrlBuilder;

import java.util.Optional;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/6 10:57
 * @description: 公司
 */
public class Test09 {
    public static void main(String[] args) {
        UrlBuilder urlBuilder = UrlBuilder.ofHttp("");
        //String token = urlBuilder.getQuery().get("token").toString();
        String token = Optional.ofNullable(urlBuilder.getQuery()).map(k->k.get("token")).map(CharSequence::toString).orElse("");
        System.out.println(token);
        System.out.println(urlBuilder.getQuery().get("token"));
    }
}
