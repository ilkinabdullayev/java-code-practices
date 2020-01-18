package info.ilkinabdullayev.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataFetcher {

    private static final List<String> DUMMY = Arrays.asList("How", "Are", "U", "World");

    CompletableFuture<Void> futureDatabase = CompletableFuture.runAsync(() -> {
        DUMMY.forEach(f -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s - %s %n", Thread.currentThread().getName(), f);
        });
    });

    CompletableFuture<Void> futureFileSystem = CompletableFuture.runAsync(() -> {
        DUMMY.forEach(f -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s - %s %n", Thread.currentThread().getName(), f);
        });
    });

    public static void main(String[] args) {
        new DataFetcher().anyOf();
    }

    private void anyOf() {
        System.out.println("Program anyOf started");

        CompletableFuture anyOfFuture = CompletableFuture.anyOf(futureDatabase, futureFileSystem);
        System.out.println("Program anyOf has been defined");

        anyOfFuture.join();

        System.out.println("Program anyOf has been executed");
    }


    private void allOf() {
        System.out.println("Program allOf started");

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureDatabase, futureFileSystem);
        System.out.println("Program allOf has been defined");

        allFuture.join();

        System.out.println("Program allOf has been executed");
    }

    private void runAsync() {
        System.out.println("Program runAsync started");


        System.out.println("Program runAsync has been defined");
        futureDatabase.join();
        futureFileSystem.join();

        System.out.println("Program runAsync has been executed");
    }
}
