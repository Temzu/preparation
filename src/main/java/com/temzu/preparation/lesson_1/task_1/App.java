package com.temzu.preparation.lesson_1.task_1;

public class App {
    public static void main(String[] args) {
        Person person = new Person().builder()
                .addAddress("Address")
                .addAge(12)
                .build();
        System.out.println(person);
    }
}
