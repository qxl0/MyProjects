package com.qiang.shared;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class helper {
    public static List<Integer> toList(int[] arr){
        return Arrays.stream(arr).boxed()
                .collect(Collectors.toList());
    }
    public static List<List<Integer>> parseList(String s){
        //String s  = "[[7], [2,2,3]]";

        return Arrays.stream(s.split("], \\["))
                .map(row -> row.replace("[[", "").replace("]]", ""))
                .map(row -> Arrays.stream(row.split(","))
                        .map(Integer::parseInt).collect(Collectors.toList())
                ).collect(Collectors.toList());
    }
    public static List<List<Integer>> toListList(int[][] source){
        List<List<Integer>> result = Arrays.stream(source)         // Stream<int[]>
                .map(Arrays::stream)                               // Stream<IntStream>
                .map(IntStream::boxed)                             // Stream<Stream<Integer>>
                .map(values -> values.collect(Collectors.toList())) // Stream<List<Integer>>
                .collect(Collectors.toList());              // List<List<Integer>>
        return result;
    }
    public static List<List<Integer>> toListList2(Integer[][] source){
        List<List<Integer>> result = Arrays.stream(source)     // Stream<Integer[]>
                .map(Arrays::asList)                               // Stream<List<Integer>>
                .collect(Collectors.toList());                      // List<List<Integer>>
        return result;
    }
    public static List<List<Integer>> toListList3(Integer[][] source){
        List<List<Integer>> result = Arrays.stream(source)     // Stream<Integer[]>
                .map(Arrays::stream)                               // Stream<Stream<Integer>>
                .map(values -> values.collect(Collectors.toList())) // Stream<List<Integer>>
                .collect(Collectors.toList());                      // List<List<Integer>>
        return result;
    }
}
