package ir.bki.HackerRank.s7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        System.out.println("arr = " + arr);
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
            leftDiagonal += arr.get(i).get(i);
            stack.push(i);
        }
        for (List<Integer> integers : arr) {
            rightDiagonal += integers.get(stack.pop());
        }
        return Math.abs(leftDiagonal-rightDiagonal);
    }
}
