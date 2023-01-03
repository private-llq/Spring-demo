package org.example.test;

/**
 * @author liuliangqi
 * @date 2023/1/3 9:36
 */
//public class UserThreadFactory implements ThreadFactory {
//    private final String namePrefix;
//    private final AtomicInteger nextId = new AtomicInteger(1);
//
//    public UserThreadFactory(String whatFeaturOfGroup) {
//        namePrefix = "From UserThreadFactory's " + whatFeaturOfGroup + "-Worker-";
//    }
//
//    @Override
//    public Thread newThread(Runnable task) {
//        String name = namePrefix + nextId.getAndIncrement();
//        Thread thread = new Thread(task, name, 0, false);
//        System.out.println(thread.getName());
//        return thread;
//    }
//}
