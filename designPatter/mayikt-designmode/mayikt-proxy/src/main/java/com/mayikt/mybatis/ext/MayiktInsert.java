package com.mayikt.mybatis.ext;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @author 余胜军
 * @ClassName MayiktInsert
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface MayiktInsert {
    String value();
}
