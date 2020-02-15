package info.ilkinabdullayev.basic.lesson10;

import info.ilkinabdullayev.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create(22, "Ilkin");

        Arrays.asList("1", "2", "3").forEach(f -> {
            System.out.println(f);
            if (f.equals("2")) {
                return;
            }
        });

        boolean isA = Stream.of().allMatch(f -> f.equals("1"));
        System.out.println(isA);

        System.out.println(IntStream.of().sum() + 1 == IntStream.of(1).sum());
        System.out.println(IntStream.range(2,2).noneMatch(f -> true));

        listPrimes(7).forEach(System.out::println);

        System.out.println(countPrimes(5));

        boolean a = countPrimes(9) == listPrimes(9).size();
        System.out.println(a);
    }

    private static long countPrimes(int max) {
        return LongStream.rangeClosed(1, max).parallel().filter(Main::isPrime).count();
    }

    private static boolean isPrime(long n) {
        return n > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }

    private static boolean isPrime2(int number) {
        return number > 1
                && IntStream.range(2, number).noneMatch(div -> number % div == 0);
    }


    private static List listPrimes(int max) {
        return IntStream.rangeClosed(1, max)
                .filter(Main::isPrime2).boxed().collect(Collectors.toList());
    }
}
