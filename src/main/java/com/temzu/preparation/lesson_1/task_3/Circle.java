package com.temzu.preparation.lesson_1.task_3;

public class Circle implements Figure {
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }

    @Override
    public void erase() {
        System.out.println("Erase Circle");
    }

    @Override
    public void move() {
        System.out.println("Move Circle");
    }
}
