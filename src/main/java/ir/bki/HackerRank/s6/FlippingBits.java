package ir.bki.HackerRank.s6;

import java.io.*;
import java.util.stream.IntStream;

public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static long flippingBits(long n) {
        // Write your code here
        return Long.parseLong(
                String.format("%32s", Long.toBinaryString(n))
                        .replaceAll(" ", "0")
                        .replaceAll("0", "t")
                        .replaceAll("1", "0")
                        .replaceAll("t", "1"), 2);
    }
}
