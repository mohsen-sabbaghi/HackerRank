package ir.bki.HackerRank.s10;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TwoArrays {

    public static void main(String[] args) throws IOException {
        Set<List<Integer>> set = new HashSet<>();
        set.forEach(x -> {
            System.err.println(java.util.Arrays.toString(x.toArray()));
        });
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String twoArraysMahdi(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        System.out.println("k = " + k + ", A = " + A + ", B = " + B);
        List<Integer> primA = new ArrayList<>();
        List<Integer> primB = new ArrayList<>();

        Iterator<Integer> iteratorA = A.iterator();

        int counter = 0;
        int n = A.size();
        if (A.size() <= 1000 && A.size() >= 1 && B.size() <= 1000 && B.size() >= 1) {
            if (k >= 1 && k <= Math.pow(10.0D, 9.0D)) {
                int i = 0;
                while (iteratorA.hasNext()) {
                    int itemA = iteratorA.next();
//                    System.out.println("itemA: "+itemA);
                    Iterator<Integer> iteratorB = B.iterator();
                    while (iteratorB.hasNext()) {
                        int itemB = iteratorB.next();
//                       System.out.println("itemB: "+itemB);
                        if (itemA + itemB == k) {
                            primA.add(itemA);
                            primB.add(itemB);
                            iteratorA.remove();
//                             B.iterator().remove();
                            System.out.println(itemA + ": " + itemB);
                        }
//                        System.err.println(A.get(i) + " + " +  B.get(j) + " = " + (A.get(i) +  B.get(j)));
                    }
                }

//                System.err.println("A " + A + " A' " + primA + "\nB " + B + " B' " + primB);
//                System.out.println("*k = " + k + ", A = " + A + ", B = " + B);


                if (primA.size() == A.size() && primB.size() == B.size()) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        System.out.println("k = " + k + ", A = " + A + ", B = " + B);
        List<Integer> primA = new ArrayList<>();
        List<Integer> primB = new ArrayList<>();


        if (A.size() <= 1000 && A.size() >= 1 && B.size() <= 1000 && B.size() >= 1) {
            if (k >= 1 && k <= Math.pow(10.0D, 9.0D)) {

                 permute(A,k);
                for (List<Integer> item : per ) {
                    System.err.println(item);
                }
//                System.err.println(permute(A));


            }
        }

        return "NO";
    }

//    public static List<List<Integer>> permute(List<Integer> nums) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//        if (nums == null || nums.size() == 0) {
//            return results;
//        }
//        List<Integer> result = new ArrayList<>();
//        dfs(nums, results, result);
//        return results;
//    }
//
//    public static void dfs(List<Integer> nums, List<List<Integer>> results, List<Integer> result) {
//        if (nums.size() == result.size()) {
//            List<Integer> temp = new ArrayList<>(result);
//            results.add(temp);
//        }
//        for (int i = 0; i < nums.size(); i++) {
//            if (!result.contains(nums.get(i))) {
//                result.add(nums.get(i));
//                dfs(nums, results, result);
//                result.remove(result.size() - 1);
//            }
//        }
//    }

    static List<List<Integer>> per = new ArrayList<>();

    static void permute(List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
//            per.add(arr);
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
}
