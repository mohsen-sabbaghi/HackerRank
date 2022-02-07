package ir.bki.HackerRank.week1exam;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void fizzBuzz(int n) {
        // Write your code here
        if (n > 0 && n < (2 * Math.pow(10, 5))) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz");
                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }
        }
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int result = 0;
        Collections.sort(arr);

        if (arr.size() >= 1 && arr.size() <= 1000001 && arr.size() % 2 != 0) {
            result = arr.get(arr.size() / 2);
            if (result >= -10000 && result <= 10000) {
                return result;
            }
        }

        return result;
    }
}
