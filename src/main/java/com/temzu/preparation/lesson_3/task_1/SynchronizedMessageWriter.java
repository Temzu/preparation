package com.temzu.preparation.lesson_3.task_1;

import java.util.concurrent.atomic.AtomicBoolean;

public class SynchronizedMessageWriter {
    private final String message;
    private final AtomicBoolean flag;
    private final boolean state;


    public SynchronizedMessageWriter(String message, AtomicBoolean flag, boolean state) {
        this.message = message;
        this.flag = flag;
        this.state = state;
    }

    public synchronized void work() {
        while (!Thread.currentThread().isInterrupted()) {
            while (state != flag.get()) {
                try {
                    long delay = (long) (1000 + 1000 * Math.random());
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    return;
                }
            }
            flag.set(!state);
            System.out.println(message);
        }
    }

    public synchronized void stop() {
        Thread.currentThread().interrupt();
    }
}
