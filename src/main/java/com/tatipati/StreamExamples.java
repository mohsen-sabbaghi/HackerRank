package com.tatipati;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {

    static Predicate<Integer> predicatedGreaterThanZero = x -> x > 0;

    public static void main(String[] args) {
        List<String> list = List.of("hi", "bye", "bad", "hi", "bad", "bad");

        ArrayList listUniques = new ArrayList<>(new HashSet(list));
        System.out.println("listUniques: " + listUniques);

        List<String> listUnique2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("listUnique2: " + listUnique2);

        Map<String, Integer> mapCount = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.summingInt(x -> 1)));
        System.out.println("mapCount: " + mapCount);
        //----- TODO
        Function<Integer, String> functionOddEven = x -> x % 2 == 0 ? "EVEN" : "ODD";
        List<Integer> listNumber = List.of(-1, 0, 1, 1, 2, 2, 2, 3, 4, 5, 6, 7); // key {EVEN , ODD} , value// [1,3,5] [2,4,6]
        Map<String, List<Integer>> oddEven = listNumber.stream().distinct().collect(Collectors.groupingBy(functionOddEven, Collectors.toList()));
        System.out.println("oddEven: " + oddEven);

        Map<String, Long> oddEvenCount = listNumber.stream().filter(predicatedGreaterThanZero).distinct().collect(Collectors.groupingBy(functionOddEven, Collectors.counting()));
        System.out.println("oddEvenCount: " + oddEvenCount);


        List<Integer> linkedCountValue =
                mapCount.values().stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        System.out.println("linkedCountValue: " + linkedCountValue);

        LinkedHashMap<String, Integer> linkedCount =
                mapCount.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (x, y) -> {
                                    throw new RuntimeException();
                                }, LinkedHashMap::new));
        System.out.println("linkedCount: " + linkedCount);
    }

}
