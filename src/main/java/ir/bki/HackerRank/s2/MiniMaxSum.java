package ir.bki.HackerRank.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = Collections.min(arr);
        int max = Collections.max(arr);
        long minSum = 0;
        long maxSum = 0;

        if (min >= 1 && max <= 1000000000) {
            if (min == max) {
                minSum = (long) min * (arr.size() - 1);
                maxSum = minSum;
            }
            for (Integer integer : arr) {

                if (integer != min) {
                    maxSum += integer;
                }
                if (integer != max) {
                    minSum += integer;
                }
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

}
