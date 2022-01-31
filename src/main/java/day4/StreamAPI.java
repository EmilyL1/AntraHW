package day4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //map
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        //flatmap
        // Creating a List of Strings
        List<String> list = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");

        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::print);

        //filter
        long count = numbers.stream().filter(i -> i>3).count();
        System.out.println(count);
        //foreach
        numbers.stream().forEach(System.out::print);
        System.out.println();
        //limit
        numbers.stream().limit(3).forEach(System.out::print);
        System.out.println();
        //sorted
        numbers.stream().limit(3).sorted().forEach(System.out::print);
        System.out.println();
        //distinct
        numbers.stream().distinct().limit(3).sorted().forEach(System.out::print);
        System.out.println();
        //collect
        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        System.out.println(set);
        //reduce
        int even = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        System.out.println(even);
        //maptoint
        List<String> strings = Arrays.asList("3", "2", "2", "3", "7", "3", "5");
        strings.stream().mapToInt(num -> Integer.parseInt(num)).forEach(System.out::print);

    }
}
