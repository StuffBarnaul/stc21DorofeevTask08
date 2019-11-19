package ru.dorofeev.homework.task08;

public class CountLine extends Thread {
    int[][] field;
    int[][] iteration;
    int height;
    int width;
    int i;

    public CountLine(int i, int[][] field, int[][] iteration) {
        this.field = field;
        this.iteration = iteration;
        this.height = field.length;
        this.width = field[0].length;
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < height; j++) {
            LifeUtils.step(i,j,field,iteration);
        }
    }
}
