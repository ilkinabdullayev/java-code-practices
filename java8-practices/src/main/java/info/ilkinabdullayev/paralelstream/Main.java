package info.ilkinabdullayev.paralelstream;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Arrays.asList(1, 5, 3, 7, 11, 9, 15, 13)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(n -> n > 0)
                .sorted()
                .forEach(System.out::println);
    }
}
