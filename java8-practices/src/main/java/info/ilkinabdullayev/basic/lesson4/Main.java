package info.ilkinabdullayev.basic.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<String> helloConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello: " + s + "!");
            }
        }.andThen(
                name -> System.out.println("Bye: " + name + "!")
        );

        helloConsumer.accept("Ilkin");


        List<String> names = Arrays.asList("Ilkin", "David", "Andrea");

        listOperation(names, helloConsumer);

        names.forEach(System.out::println);
        names.forEach(Main::print);
    }


    public static void listOperationOldSchool(List<String> list, Consumer<String> consumer) {
        Objects.requireNonNull(consumer);// fast-fail
        for (String s: list) {
            consumer.accept(s);
        }
    }

    public static void listOperation(List<String> list, Consumer<String> consumer) {
        list.forEach(consumer);
    }

    public static void print(String value) {
        System.out.println("Ref method:" + value);
    }
}
