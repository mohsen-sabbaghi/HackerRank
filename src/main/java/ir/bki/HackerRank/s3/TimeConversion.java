package ir.bki.HackerRank.s3;

import java.io.*;

public class TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String timeConversion(String s) {
        // Write your code here
        if (s.equalsIgnoreCase("12:00:00AM"))
            return "00:00:00";
        if (s.equalsIgnoreCase("12:00:00PM"))
            return "12:00:00";

        String[] parts = s.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        int sec = Integer.parseInt(parts[2].substring(0, 2));
        String ind = parts[2].substring(2, 4).trim();

        if (ind.equalsIgnoreCase("PM") && hour < 12) {
            hour += 12;
        }
        if (ind.equalsIgnoreCase("AM") && hour == 12) {
            hour -= 12;
        }
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

}
