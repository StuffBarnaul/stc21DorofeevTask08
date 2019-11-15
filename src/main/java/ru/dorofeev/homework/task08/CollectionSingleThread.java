//package ru.dorofeev.homework.task08;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class CollectionSingleThread {
//    ArrayList<ArrayList<Cell>> field = new ArrayList<>();
//    int width;
//    int height;
//
//    public void count(String input,String output, int iterations) {
//        long start = System.currentTimeMillis();
//        field = readData(input);
//        for (int i = 0; i < iterations; i++) {
//            field = move(field);
//        }
//        writeData(field, output);
//        long end = System.currentTimeMillis();
//        System.out.println(String.format("Field size: %s x %s", width, height));
//        System.out.println(String.format("Method: SingleThread"));
//        System.out.println(String.format("Number of iterations: %s", iterations));
//        System.out.println(String.format("Time: %s", end-start));
//    }
//
//    private int[][] readData(String inputfile) throws IOException {
//        Files.lines(Paths.get(inputfile))
//                .flatMap( s -> Stream.of(s.toCharArray()))
//                .map(Character::valueOf)
//                .collect(Collectors.toList());
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputfile)))){
//            ArrayList<String> list = new ArrayList<>();
//            Stream stream =
//            while (true){
//                String line = reader.readLine();
//                if (line == null) break;
//                int[] chars = (int[]) line.toCharArray();
//                Arrays.stream(chars);
//                Stream<String> streamFromCollection = .stream();
//                list.add(line);
//                if (list.get(0).length() != line.length()) throw new IllegalArgumentException();
//            }
//            width = list.get(0).length();
//            height = list.size();
//            int[][] field = new int[height][width];
//            for (int i = 0; i < height ; i++) {
//                for (int j = 0; j < width; j++) {
//                    if (list.get(i).charAt(j) == 48) field[i][j] = 0;
//                    else field[i][j] = 1;
//                }
//            }
//            return field;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//}
