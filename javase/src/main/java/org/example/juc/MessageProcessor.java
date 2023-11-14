package org.example.juc;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class MessageProcessor {
    private ExecutorService executor;


    public MessageProcessor(int numThreads) {
        // 创建一个固定大小的线程池
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public void processMessage(Message message) {
        // 提交任务给线程池进行处理
        executor.submit(() -> {
            // 在这里编写你的消息处理逻辑
            // ...
            System.out.println("Processing message: " + message.getContent());
        });
    }

    public void shutdown() {
        // 关闭线程池
        executor.shutdown();
    }

    public static void main(String[] args) {
        // 创建一个包含5个线程的消息处理线程池
        MessageProcessor processor = new MessageProcessor(5);

        // 模拟处理一些消息
        for (int i = 0; i < 10; i++) {
            Message message = new Message("Message " + i);
            processor.processMessage(message);
        }

        // 关闭线程池
        processor.shutdown();
    }
}

class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
