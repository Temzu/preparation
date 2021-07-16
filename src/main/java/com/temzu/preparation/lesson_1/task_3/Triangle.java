package com.temzu.preparation.lesson_1.task_3;

public class Triangle implements Figure {
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase triangle");
    }

    @Override
    public void move() {
        System.out.println("Move triangle");
    }
}
