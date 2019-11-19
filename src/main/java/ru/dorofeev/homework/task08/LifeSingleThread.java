package ru.dorofeev.homework.task08;

public class LifeSingleThread {
    private int width;
    private int height;

    public void count(String input,String output, int iterations) {
        long start = System.currentTimeMillis();
        int[][] field = LifeUtils.readData(input);
        width = field[0].length;
        height = field.length;
        for (int i = 0; i < iterations; i++) {
            field = step(field);
        }
        LifeUtils.writeData(field, output);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Field size: %s x %s", width, height));
        System.out.println("Method: SingleThread");
        System.out.println(String.format("Number of iterations: %s", iterations));
        System.out.println(String.format("Time: %s", end-start));
    }

    private int[][] step(int[][] field) {
        int[][] iteration = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                LifeUtils.step(i,j,field,iteration);
            }
        }
        return iteration;
    }
}
