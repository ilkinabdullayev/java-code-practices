package info.ilkinabdullayev.basic.lesson5;


import info.ilkinabdullayev.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Consumer<String> consumerMessage = message -> System.out.println(message);
        consumerMessage.accept("Hello from outside!");

        BiConsumer<String, Integer> consumerHost = (host, port)  -> System.out.println("https://" + host + ":" + port);
        consumerHost.accept("172.22.22.22", 8080);

        Function<Integer, Double> sqrtFunction = number -> Math.sqrt(number);
        double resultSqrt = sqrtFunction.apply(4);
        System.out.println("Result sqrtFunction: " + resultSqrt);

        BiFunction<Integer, Integer, String> summarizeStringBiFunction = (n1, n2) -> n1 + "" + n2;
        String resultSummarize = summarizeStringBiFunction.apply(23, 34);
        System.out.println("Result: summarizeStringBiFunction " + resultSummarize);

        UnaryOperator<Integer> sqrtUnaryOperator = number -> (int) Math.sqrt(number);
        int resultSqrtInt = sqrtUnaryOperator.apply(4);
        System.out.println("Result sqrtUnaryOperator: " + resultSqrtInt);

        BinaryOperator<String> joinCommaStringsBinaryOperator = (s1,s2) -> String.join(",", s1, s2);
        String resultJoinCommaStrings = joinCommaStringsBinaryOperator.apply("Hello", "World");
        System.out.println("Result joinCommaStringsBinaryOperator: " + resultJoinCommaStrings);

        Predicate<Integer> predicateComparison = number -> number > 5;
        System.out.println("Result predicateComparison: " + predicateComparison.test(7));

        BiPredicate<String, Integer> predicateComparisonTextLength = (text, length) -> text.length() > length;
        System.out.println("Result predicateComparisonTextLength: " + predicateComparisonTextLength.test("Hello", 7));

        Supplier<Person> personSupplier = () -> new Person(1, "Ilkin");
        System.out.println("Result personSupplier: " + personSupplier.get());

        Supplier<Person> personSupplierMethodRef = Person::new;
        System.out.println("Result personSupplierMethodRef: " + personSupplierMethodRef.get());

    }

    //Exercise 1
    private void sortList() {
        List<String> persons = Arrays.asList("Ilkin", "David", "Andrea");
        //Comparator -> BiFunction
        Collections.sort(persons, (p1, p2) -> p1.compareTo(p2)); //skip natural order; it is just example
    }
}
