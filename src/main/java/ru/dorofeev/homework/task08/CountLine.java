package ru.dorofeev.homework.task08;

public class CountLine extends Thread {
    int[][] field;
    int[][] iteration;
    int height;
    int width;
    int i;

    public CountLine(int[][] field, int[][] iteration, int i) {
        this.field = field;
        this.iteration = iteration;
        this.height = field.length;
        this.width = field[0].length;
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < height; j++) {
            int innerHeight = height+i;
            int innerWidth = width+j;
            int neightbours = 0;
            if (field[(innerHeight-1)%height][(innerWidth-1)%width] != 0) neightbours++;
            if (field[(innerHeight-1)%height][(innerWidth)%width] != 0) neightbours++;
            if (field[(innerHeight-1)%height][(innerWidth+1)%width] != 0) neightbours++;
            if (field[(innerHeight)%height][(innerWidth-1)%width] != 0) neightbours++;
            if (field[(innerHeight)%height][(innerWidth+1)%width] != 0) neightbours++;
            if (field[(innerHeight+1)%height][(innerWidth-1)%width] != 0) neightbours++;
            if (field[(innerHeight+1)%height][(innerWidth)%width] != 0) neightbours++;
            if (field[(innerHeight+1)%height][(innerWidth+1)%width] != 0) neightbours++;
            //System.out.println(i+" "+j);
            if (neightbours == 2) iteration[i][j] = field[i][j];
            else if (neightbours == 3) iteration[i][j] = 1;
            else iteration[i][j] = 0;
        }
    }
}
