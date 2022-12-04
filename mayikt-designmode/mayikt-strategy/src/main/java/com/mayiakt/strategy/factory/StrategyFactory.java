package com.mayiakt.strategy.factory;

import com.mayiakt.strategy.PayStrategy;
import com.mayiakt.strategy.impl.AliPayStrategy;
import com.mayiakt.strategy.impl.UnionPayStrategy;
import com.mayiakt.strategy.impl.WeChatPayStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 余胜军
 * @ClassName StrategyFactory
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class StrategyFactory {
    /**
     * 容器 存放策略对象 应该使用多态策略 使用 接口或者抽象类
     */
    private Map<String, PayStrategy> strategys = new HashMap<>();

    /**
     * 使用无参构造方法初始化 策略配置
     */
    public StrategyFactory() {
        initStrategy();
    }

    /**
     * 初始化具体策略
     */
    public void initStrategy() {
        strategys.put("aliPayStrategy", new AliPayStrategy());
        strategys.put("unionPayStrategy", new UnionPayStrategy());
        strategys.put("weChatPayStrategy", new WeChatPayStrategy());
    }

    /**
     * @param userPayCode
     * @return
     */

    public PayStrategy getPayStrategy(String userPayCode) {
        return strategys.get(userPayCode);
    }
}
