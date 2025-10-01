package javaassignment;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
    public static void main(String[] args) {
        System.out.println("=== TASK 2: STREAM FILTER ===");
        List<Integer> numbers = Arrays.asList(10, 3, 15, 7, 20, 25, 8, 30);
        
        System.out.println("Numbers divisible by 5:");
        numbers.stream()
               .filter(n -> n % 5 == 0)
               .forEach(System.out::println);
    }
}