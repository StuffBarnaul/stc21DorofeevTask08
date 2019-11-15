package ru.dorofeev.homework.task08;

import org.junit.jupiter.api.Test;


class LifeSingleThreadTest {
    String source = "src\\main\\resources\\input.txt";
    String destination = "src\\main\\resources\\output.txt";
    int iterations = 500;
    int n = 1;

    @Test
    void count() {
        LifeSingleThread lifeSingleThread = new LifeSingleThread();
        lifeSingleThread.count(source,destination,iterations);
        System.out.println("");
        LifeMultiThread lifeMultiThread = new LifeMultiThread();
        lifeMultiThread.count(source, destination, iterations, n);
    }
}