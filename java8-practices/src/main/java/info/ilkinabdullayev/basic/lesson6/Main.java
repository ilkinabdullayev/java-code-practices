package info.ilkinabdullayev.basic.lesson6;

import info.ilkinabdullayev.Person;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        BiConsumer<String, String> fileSaverConsumer = FileUtil::saveFile;
        fileSaverConsumer.accept("/user/blabla/file.txt", "Hello World");


        Arrays.asList(
                new Person(1, "Ilkin")
        ).stream()
                .map(Person::getName);
    }

    private void createArray() {
        IntFunction<int[]> intFunction = int[]::new;
        intFunction.apply(2);
    }

    private void testReference() {
        Function<Person, String> f =  Person::getName;

        Supplier<String> uuidSupplier = this::generateUUID;

        Main main =  new Main();
        uuidSupplier = main::generateUUID;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
