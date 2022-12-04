package com.mayikt.decorate;

/**
 * @author 余胜军
 * @ClassName ComponentCache
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface ComponentCache {
    /**
     * 返回泛型T
     *
     * @param <T>
     * @return
     */
    <T> T getCache(String key);
}
