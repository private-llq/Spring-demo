package org.example.juc;

/**
 * @author llq
 */

public enum State {
    //新建 new
    NEW,
    //运行 runnable
    RUNNABLE,
    //阻塞 blocked
    BLOCKED,
    //等待 waiting
    WAITING,
    //超时等待 timed_waiting
    TIMED_WAITING,
    //终止 terminated
    TERMINATED;
}