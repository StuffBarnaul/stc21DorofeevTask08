package ru.dorofeev.homework.task08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LifeUtils {

    private static int width;
    private static int height;

    static int[][] readData(String inputfile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputfile)))){
            List<String> list = new ArrayList<>();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                list.add(line);
                if (list.get(0).length() != line.length()) throw new IllegalArgumentException();
            }
            width = list.get(0).length();
            height = list.size();
            int[][] field = new int[height][width];
            for (int i = 0; i < height ; i++) {
                for (int j = 0; j < width; j++) {
                    if (list.get(i).charAt(j) == '0') field[i][j] = 0;
                    else field[i][j] = 1;
                }
            }
            return field;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void writeData(int[][] field, String outputfile) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputfile)))){
            for (int i = 0; i < height; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < width; j++) {
                    sb.append(field[i][j]);
                }
                writer.write(sb.toString());
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void step(int i, int j, int[][] field, int[][] iteration) {
        int innerHeight = height+i;
        int innerWidth = width+j;
        int neightbours = 0;
        neightbours += field[(innerHeight-1)%height][(innerWidth-1)%width];
        neightbours += field[(innerHeight-1)%height][(innerWidth)%width];
        neightbours += field[(innerHeight-1)%height][(innerWidth+1)%width];
        neightbours += field[(innerHeight)%height][(innerWidth-1)%width];
        neightbours += field[(innerHeight)%height][(innerWidth+1)%width];
        neightbours += field[(innerHeight+1)%height][(innerWidth-1)%width];
        neightbours += field[(innerHeight+1)%height][(innerWidth)%width];
        neightbours += field[(innerHeight+1)%height][(innerWidth+1)%width];
        if (neightbours<2 || neightbours>3) iteration[i][j] = 0;
        if (neightbours == 2) iteration[i][j] = field[i][j];
        if (neightbours == 3) iteration[i][j] = 1;
    }
}
