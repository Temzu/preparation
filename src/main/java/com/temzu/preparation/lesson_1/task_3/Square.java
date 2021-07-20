package com.temzu.preparation.lesson_1.task_3;

public class Square implements Figure {
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }

    @Override
    public void erase() {
        System.out.println("Erase Square");
    }

    @Override
    public void move() {
        System.out.println("Move Square");
    }
}
