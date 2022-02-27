package ir.bki.HackerRank.deliveryhero;

import java.util.HashSet;
import java.util.Set;

public class DeliveryHero {


    public static void main(String[] args) {

        
        System.err.println("Number Alive Fish --> "+fish("ACCD"));
        System.err.println("Number Alive Fish --> "+fish("ABAD"));


    }

    static int fish(String S) {

        if (S.isEmpty() || S.length() > 1000000 && isValidString(S.toCharArray())) return -1;

        char[] chars = S.toCharArray();
        int aliveCount = chars.length;


        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        System.err.println(chars);
        System.err.println(set);

        for (int i = 0; i < aliveCount  ; i++) {

            switch (chars[i]) {
                case 'A':
                case 'a':
                    if (set.contains(chars[i]) && chars[i + 1] == 'B' || chars[i + 1] == 'C') {
                        aliveCount = aliveCount - 1;
                    }
                    break;
                case 'B':
                case 'b':
                    if (set.contains(chars[i]) && chars[i + 1] == 'C' || chars[i + 1] == 'D') {
                        aliveCount = aliveCount - 1;
                    }
                    break;
                case 'C':
                case 'c':
                    if (set.contains(chars[i]) && chars[i + 1] == 'D') {
                        aliveCount = aliveCount - 1;
                    }
                    break;
                case 'D':
                case 'd':
                    break;

            }

        }


        return aliveCount;
    }

    static boolean isValidString(char[] chars) {
        boolean valid = true;
        for (char c : chars) {
            valid = ((c == 'a') || (c == 'b') || (c == 'c') || (c == 'd')) ||
                    ((c == 'A') || (c == 'B') || (c == 'C') || (c == 'D'));
            if (!valid) {
                break;
            }
        }
        return valid;
    }


}
