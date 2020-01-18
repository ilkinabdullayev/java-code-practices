package info.ilkinabdullayev.basic.lesson9;

import info.ilkinabdullayev.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final List<String> NAMES = Arrays.asList(
            "Java",
            "Golang",
            null,
            "Test"
    );


    public static void main(String[] args) {
        int divider = 1;
        int result = IntStream.rangeClosed(1, 6)
                .reduce(0, (a, b) -> divide(a, divider) + divide(b, divider));
        System.out.println("Sum is " + result);
    }

    private static int divide(int value, int factor) {
        System.out.println(value);
        try {
            return value / factor;
        } catch (ArithmeticException exp) {
            System.out.println("Bad guy");
        }

        return 0;
    }


    private static void reduceAllData() {
        int sumResult = Arrays.asList(2, 5, 7)
                .parallelStream()
                .reduce(0, (a, b) -> a + b, (a, b) -> {
                    System.out.printf("%d, %d %n", a, b);
                    return a + b;
                });
        System.out.println("Sum is " + sumResult);


        List<Person> lsPerson = Arrays.asList(
                new Person(1, "Ilkin", 27),
                new Person(2, "David", 34),
                new Person(2, "David", 30)
        );

//        lsPerson.stream()
//                .mapToInt(Person::getAge)
//                .reduce(0, Integer::sum);

        sumResult = lsPerson.stream()
                .reduce(0,
                        (aggrVal, per) -> aggrVal + per.getAge(),
                        Integer::sum);
        System.out.println("Sum is " + sumResult);
    }


    private static void joinNamesWithReduceOp() {
        String joinedNames = NAMES.stream()
                .filter(Objects::nonNull)
                .reduce("", String::concat);
        System.out.println("joinedNames is " + joinedNames);
    }

    private static void printSumOfPrimeNumbers() {
        int[] primeNumbers = { 2, 3, 5, 7, 11, 13, 17};

        // Arrays.stream(primeNumbers).forEach(System.out::println);
        int sumResult = IntStream.of(primeNumbers)
                .reduce((o, n) -> {
                    System.out.printf("O: %d, N: %d %n", o , n);
                    return o + n;
                })
                .orElseThrow(() -> new RuntimeException("Some shitty exception"));
        System.out.println("Sum is " + sumResult);


        sumResult = IntStream.of(primeNumbers)
                .reduce(0, Integer::sum);
        System.out.println("Sum is " + sumResult);
    }

    private static void printSquaresOfRange() {
        IntStream.rangeClosed(1, 5)
                .map(i -> i * i)
                .forEach(System.out::println);
    }


    private static void groupNamesByLength() {
        NAMES.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(
                        Collectors.groupingBy(String::length)
                ).entrySet()
                .forEach(System.out::println);
    }

    private static void printNames() {
        NAMES.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    private static void printNamesAsJoined() {
        String nameCollect = NAMES.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(nameCollect);
    }

    private static void showCountOfRange() {
        long count = IntStream.rangeClosed(3, 12).count();
        System.out.println("Count is " + count);
    }
}
