package info.ilkinabdullayev;

import java.util.Arrays;
import java.util.List;

public class BasicOperations {


    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "a1", "b1", "c3", "d1", "c1", "c2"
        );


        list.stream()
                .filter(f -> f.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

    }



}
