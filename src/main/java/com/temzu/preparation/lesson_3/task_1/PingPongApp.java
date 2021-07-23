package com.temzu.preparation.lesson_3.task_1;

import java.util.concurrent.atomic.AtomicBoolean;

public class PingPongApp {

    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);
        new Thread(() -> new SynchronizedMessageWriter("Ping", flag, true).work()).start();
        new Thread(() -> new SynchronizedMessageWriter("Pong", flag, false).work()).start();
    }
}
