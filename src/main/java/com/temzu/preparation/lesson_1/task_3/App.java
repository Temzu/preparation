package com.temzu.preparation.lesson_1.task_3;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle());
        figures.add(new Square());
        figures.add(new Triangle());

        for (Figure figure : figures) {
            figure.draw();
        }

        for (Figure figure : figures) {
            figure.move();
        }

        for (Figure figure : figures) {
            figure.erase();
        }
    }
}
