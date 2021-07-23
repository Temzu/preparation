package com.temzu.preparation.lesson_3.task_2;

public class App {
    public static void main(String[] args) {
        new Thread(() -> new Counter().count()).start();
    }
}
