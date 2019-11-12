package ru.dorofeev.homework.task08;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LifeMultiThread {
    private static int width;
    private static int height;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<String> list = readData(args[0]);
        int field[][] = new int[height][width];
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).charAt(j) == 48) field[i][j] = 0;
                else field[i][j] = 1;
            }
        }
        for (int i = 0; i < Integer.valueOf(args[2]); i++) {
            field = move(field);
        }
        writeData(field, args[1]);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static int[][] move(int[][] field) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        int[][] iteration = new int[height][width];
        for (int i = 0; i < height; i++) {
            CountLine countLine = new CountLine(field, iteration, i);
            executorService.submit(countLine);
        }
        executorService.shutdown();
        return iteration;
    }

    private static void writeData(int[][] field, String outputfile) {
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

    private static ArrayList<String> readData(String inputfile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputfile)))){
            ArrayList<String> list = new ArrayList<>();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                list.add(line);
                if (list.get(0).length() != line.length()) throw new IllegalArgumentException();
            }
            width = list.get(0).length();
            height = list.size();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
