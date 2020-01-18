package info.ilkinabdullayev.completablefuture;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExplorer {

    private CompletableFuture<List<Path>> completableFuture = CompletableFuture.supplyAsync(this::getListPath1);
    private CompletableFuture<List<Path>> completableFuture2 = CompletableFuture.supplyAsync(this::getListPath2);

    private List<Path> getListPath1() {
        System.out.println("getListPath1 started");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getListPath("/PATH");
    }

    private List<Path> getListPath2() {
        System.out.println("getListPath2 started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getListPath("/PATH1");
    }

    private List<Path> getListPath(String pathString) {
        Stream<Path> pathStream = Stream.of();
        try {
            Path path = Paths.get(pathString);
            pathStream =  Files.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathStream.collect(Collectors.toList());
    }

    private void run1() {
        List<Path> paths = completableFuture.join();
        paths.stream().forEach(System.out::println);
    }

    private void run2() {
        completableFuture.join();

        completableFuture.thenAccept(c -> {
            c.forEach(System.out::println);
        });
    }

    private void run3() {
        completableFuture.runAfterBoth(completableFuture2, () -> {
            System.out.println("Finished");
        });

        List<Path> paths = completableFuture.join();
        paths.addAll(completableFuture2.join());

        paths.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new FileExplorer().run3();
    }
}
