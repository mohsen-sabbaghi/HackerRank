package ir.bki.HackerRank.week1exam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here

        List<Integer> sotoon  ;
        int result = 0;

        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(" satr: " + matrix.get(i));

//            matrix.get(i).sort(Collections.reverseOrder());
//            System.out.println("sorted i = " + matrix.get(i));
            sotoon = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sotoon.add( matrix.get(j).get(i));
            }
            sotoon.sort(Collections.reverseOrder());
            System.err.println(i+"-sorted: " + sotoon);
            matrix.get(i).sort(Collections.reverseOrder());
        }
        System.out.println("----------------------------------");
        System.out.println("matrix = " + matrix);
        for (List<Integer> integers : matrix) {
            System.out.println(integers);
            for (int j = 0; j < integers.size(); j++) {
//                result += integers.get(0);
            }
        }

        return result;

    }

}
