package com.base;

import java.util.*;
import java.util.stream.Collectors;

public class Collect {

    public static void main(String[] args) {

        {
            String a = "a";
            String x = a+1;
            if ("b".equals(x)){
                System.out.println("hi");
            }
        }

        {
            //通过 key and value 过滤
            Map<String, String> map = new HashMap<String, String>();
            map.put("1","a");
            map.put("2","b");
            map.put("3","c");
            map.put("4","d");
            map.put("5","e");
            map.put("6","f");

            Set<Long> set = new HashSet<>();
            set.add(1L);
            set.add(3L);

            String a = map.entrySet().stream()
                    .filter(entry -> set.contains(Long.valueOf(entry.getKey())))
                    .map(entry -> entry.getValue()+1)
                    .filter(entry -> entry.equals("a1") || entry.equals("c1"))
                    .collect(Collectors.joining("="));

            System.out.println(a);

        }

        {
            //通过 key and value 过滤
            Map<String, String> map = new HashMap<String, String>();
            map.put("1","a");
            map.put("2","b");
            map.put("3","c");
            map.put("4","d");

            Set<Long> set = new HashSet<>();
            set.add(1L);
            set.add(3L);

            Map<String, String>  filtered = map.entrySet().stream()
                    .filter(entry -> set.contains(Long.valueOf(entry.getKey())))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//                    .map(entry -> entry.getValue()+1)
//                    .filter(entry -> entry.equals("b"))
//                    .
            System.out.println(filtered);


        }

        {
            //统计
            List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
            IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
            System.out.println("列表中最大的数 : " + stats.getMax());
            System.out.println("列表中最小的数 : " + stats.getMin());
            System.out.println("所有数之和 : " + stats.getSum());
            System.out.println("平均数 : " + stats.getAverage());
        }

        //过滤空白 parallel
        List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered2 = strings3.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered2);

        String merge = strings3.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.joining("|"));
        System.out.println(merge); //abc|bc|efg|abcd|jkl

        //过滤空白
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        //对流排序
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(System.out::println);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        //squaresList.stream().forEach(System.out.print());
        System.out.println(squaresList);


        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }

}
