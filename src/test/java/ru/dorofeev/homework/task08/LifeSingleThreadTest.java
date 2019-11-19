package ru.dorofeev.homework.task08;

import org.junit.jupiter.api.Test;


class LifeSingleThreadTest {

    @Test
    void count() {
        LifeSingleThread lifeSingleThread = new LifeSingleThread();
        String source = "src\\main\\resources\\input.txt";
        String destination = "src\\main\\resources\\output.txt";
        int iterations = 500;
        lifeSingleThread.count(source, destination, iterations);
        System.out.println("");
        LifeMultiThread lifeMultiThread = new LifeMultiThread();
        int n = 2;
        lifeMultiThread.count(source, destination, iterations, n);
    }
}