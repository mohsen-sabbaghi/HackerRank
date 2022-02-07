package ir.bki.HackerRank.s9;

import java.io.*;
import java.util.Locale;

public class Pangrams {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    //    The quick brown fox jumps over the lazy dog
    //    We promptly judged antique ivory buckles for the prize
    public static String pangrams(String s) {
        String[] ALPHABET = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " "};
        boolean isPangram = true;
        for (String value : ALPHABET) {
            if (!s.trim().toLowerCase(Locale.ROOT).contains(value)) {
                isPangram = false;
                break;
            }
        }
        return isPangram ? "pangram" : "not pangram";
    }

}
