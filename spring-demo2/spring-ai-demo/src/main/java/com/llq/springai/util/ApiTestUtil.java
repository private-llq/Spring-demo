package com.llq.springai.util;


import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import com.alibaba.dashscope.utils.JsonUtils;
import io.reactivex.Flowable;

import java.util.Arrays;

public class ApiTestUtil {
 
    public static String getProblem(String problem) throws NoApiKeyException, InputRequiredException {
        Constants.apiKey = "sk-458c4d5d057949599e3423215a488794";
        // 实例化生成器对象
        Generation gen = new Generation();
        // 构建用户消息，角色为USER，内容为中国首都的介绍
        Message userMsg =
                Message.builder().role(Role.USER.getValue()).content(problem).build();
        // 构建生成参数，包括模型名称、消息列表、结果格式等
        GenerationParam param = GenerationParam.builder()
                .model("qwen-max") // 选择使用的模型
                .messages(Arrays.asList(userMsg)) // 用户的询问消息
                .resultFormat(GenerationParam.ResultFormat.MESSAGE) // 结果以消息格式返回
                .topP(0.8).enableSearch(true) // 设置搜索启用及topP参数
                .incrementalOutput(true) // 以增量方式获取流式输出
                .build();
        // 调用生成器的流式调用方法，返回结果为一个Flowable流
        Flowable<GenerationResult> result = gen.streamCall(param);
        // 使用StringBuilder来拼接完整的回复内容
        StringBuilder fullContent = new StringBuilder();
        // 阻塞方式处理每一个流式输出的消息，并打印出来
        result.blockingForEach(message -> {
            // 将当前消息的内容追加到完整内容中
            fullContent.append(message.getOutput().getChoices().get(0).getMessage().getContent());
            // 打印当前的消息内容（JSON格式）
            System.out.println(JsonUtils.toJson(message));
        });
        // 打印最终的完整内容
        System.out.println("Full content: \n" + fullContent.toString());
        return fullContent.toString();
    }
}