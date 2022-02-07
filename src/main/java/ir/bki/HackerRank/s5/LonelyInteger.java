package ir.bki.HackerRank.s5;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < a.size(); i++) {
            for (Integer integer : a) {
                if (Objects.equals(a.get(i), integer)) {
                    cnt++;
                }
            }
            map.put(a.get(i),cnt);
            cnt = 0;
        }

        for (Integer item: map.keySet()) {
            int value = map.get(item) ;
            if (value == 1) {
                result =item;
            }
        }

        return result;
    }
}
