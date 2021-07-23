package com.temzu.preparation.lesson_3.task_2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final AtomicInteger value = new AtomicInteger(0);

    public void count() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            increment();
            System.out.println(getValue());
        }
    }

    public void increment() {
        try {
            lock.writeLock().lock();
            value.incrementAndGet();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getValue() {
        try {
            lock.readLock().lock();
            return value.intValue();
        } finally {
            lock.readLock().unlock();
        }
    }
}
