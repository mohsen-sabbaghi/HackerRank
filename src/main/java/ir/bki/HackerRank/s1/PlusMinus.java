package ir.bki.HackerRank.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float plusCount = 0;
        float minusCount = 0;
        float containZero = 0;
        float totalCount = arr.size();
        ArrayList<Float> result = new ArrayList<>();

        for (Integer integer : arr) {
            if (integer > 0) {
                plusCount++;
            } else if (integer < 0) {
                minusCount++;
            } else {
                containZero++;
            }
        }

        result.add(plusCount / totalCount);
        result.add(minusCount / totalCount);
        if (containZero != 0) {
            result.add(containZero / (float) arr.size());
        }else {
            result.add(containZero);
        }

        for (Float value : result) {
            System.out.printf("%.6f %n", value);
        }

    }

}
