//package com.llq.springai.controller;
//
//import io.github.lnyocly.ai4j.platform.openai.chat.entity.ChatCompletion;
//import io.github.lnyocly.ai4j.platform.openai.chat.entity.ChatCompletionResponse;
//import io.github.lnyocly.ai4j.platform.openai.chat.entity.ChatMessage;
//import io.github.lnyocly.ai4j.service.IChatService;
//import io.github.lnyocly.ai4j.service.PlatformType;
//import io.github.lnyocly.ai4j.service.factor.AiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//chatgpt访问超时
//public class OpenAiController {
//
//    // 注入Ai服务
//    @Autowired
//    private AiService aiService;
//
//    @GetMapping("/chat")
//    public String getChatMessage(@RequestParam String question) throws Exception {
//        // 获取OpenAi的聊天服务
//        IChatService chatService = aiService.getChatService(PlatformType.OPENAI);
//
//        // 创建请求参数
//        ChatCompletion chatCompletion = ChatCompletion.builder()
//                .model("gpt-4o-mini")
//                .message(ChatMessage.withUser(question))
//                .build();
//
//
//        System.out.println(chatCompletion);
//
//        // 发送chat请求
//        ChatCompletionResponse chatCompletionResponse = chatService.chatCompletion(chatCompletion);
//
//        // 获取聊天内容和token消耗
//        String content = chatCompletionResponse.getChoices().get(0).getMessage().getContent();
//        long totalTokens = chatCompletionResponse.getUsage().getTotalTokens();
//        System.out.println("总token消耗: " + totalTokens);
//
//        return content;
//    }
//}
