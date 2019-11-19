package ru.dorofeev.homework.task08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LifeMultiThread {
    private static int width;
    private static int height;

    public void count(String input,String output, int iterations, int numberOfThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        long start = System.currentTimeMillis();
        int[][] field = LifeUtils.readData(input);
        width = field[0].length;
        height = field.length;
        for (int i = 0; i < iterations; i++) {
            field = step(field,executorService);
        }
        LifeUtils.writeData(field, output);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Field size: %s x %s", width, height));
        System.out.println("Method: MultiThread");
        System.out.println(String.format("Number of iterations: %s", iterations));
        System.out.println(String.format("Number of Threads: %s", numberOfThreads));
        System.out.println(String.format("Time: %s", end-start));
    }

    private static int[][] step(int[][] field, ExecutorService executorService) {
        int[][] iteration = new int[height][width];
        for (int i = 0; i < height; i++) {
            executorService.submit(new CountLine(i, field, iteration));
        }
        return iteration;
    }
}

