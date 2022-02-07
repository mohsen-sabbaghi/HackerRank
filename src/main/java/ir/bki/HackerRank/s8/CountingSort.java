package ir.bki.HackerRank.s8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        if (arr.size() >= 100 && arr.size() <= 1000000) {

//            System.err.println("arr.size() -> " + arr.size());

            ArrayList<Integer> zeroFilled = new ArrayList<>(Collections.nCopies(100, 0));

//            System.out.println("zeroFilled size: " + arr.size() + "\n" + zeroFilled);

            for (Integer integer : arr) {
                if (zeroFilled.get(integer) <= 0) {
                    zeroFilled.set(integer, 1);
                } else {
                    zeroFilled.set(integer, zeroFilled.get(integer) + 1);
                }
            }

//            System.out.println("zeroFilled size: " + zeroFilled.size() + "\n" + zeroFilled);

            return zeroFilled;
        }
        return arr;
    }
}
