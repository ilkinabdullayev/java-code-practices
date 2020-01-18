package info.ilkinabdullayev.basic.lesson8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/PATH");
        Stream<Path> pathStream = Files.list(dir);

        pathStream.forEach(System.out::println);
        ///////////////IntStream
        System.out.println("intStream1");
        Supplier<IntStream> intStreamSupplier = () -> IntStream.of(2, 4, 5);
        intStreamSupplier.get().forEach(System.out::print);

        System.out.println("\nintStream2");
        Supplier<IntStream> intStreamSupplier2 = () -> IntStream.rangeClosed(3, 11);
        intStreamSupplier2.get().forEach(System.out::print);

        System.out.println("\nintStream3");
        IntStream intStream3 = IntStream.concat(intStreamSupplier.get(), intStreamSupplier2.get());
        intStream3
                .distinct()
                .sorted()
                .forEach(System.out::print);
        ///////////////DoubleStream
        double sum = DoubleStream.iterate(0, i -> i + 1)
                .limit(10)
             //   .skip(2)
                .peek(System.out::print)
                .sum();
        System.out.println("\nDouble sum is: " + sum);
        ///////////////LongStream
        LongStream longStream = LongStream.of(Long.MAX_VALUE, 2, 85);
        longStream.forEach(System.out::println);

       // Map.Entry.o
    }
}
