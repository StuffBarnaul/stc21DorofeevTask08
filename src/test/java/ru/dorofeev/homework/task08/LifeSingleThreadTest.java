package ru.dorofeev.homework.task08;

import org.junit.jupiter.api.Test;


class LifeSingleThreadTest {
    String a1 = "C:\\Users\\user\\IdeaProjects\\task08\\src\\main\\resources\\input.txt";
    String a2 = "C:\\Users\\user\\IdeaProjects\\task08\\src\\main\\resources\\output.txt";
    int a3 = 5000;

    @Test
    void count() {
        LifeSingleThread lifeSingleThread = new LifeSingleThread();
        lifeSingleThread.count(a1,a2,a3);
        System.out.println("");
        LifeMultiThread lifeMultiThread = new LifeMultiThread();
        lifeMultiThread.count(a1,a2,a3);
    }
}