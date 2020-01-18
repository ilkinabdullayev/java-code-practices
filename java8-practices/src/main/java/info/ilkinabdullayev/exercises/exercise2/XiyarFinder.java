package info.ilkinabdullayev.exercises.exercise2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XiyarFinder {

    private static final XiyarWalker XIYAR_WALKER = new XiyarFinder.XiyarWalker();

    public static void main(String[] args) {
        XIYAR_WALKER.walk();
    }

    public static class XiyarWalker {

        private static final String ROOT_PATH = "/PATH";

        //to find all files and folders by the path as asynchronously
        private CompletableFuture<List<Path>> completablePathFinder = CompletableFuture.supplyAsync(this::getRootPath);

        //to calculate size of found file paths as asynchronously
        private CompletableFuture<Map<Path, Long>> completablePathSizeCalculator = completablePathFinder.handleAsync(this::calculatePathSize);

        //to list file paths and size of them as asynchronously
        private CompletableFuture<Void> completablePrint = completablePathSizeCalculator.thenAccept(this::printMap);


        public void walk() {
            completablePrint.join();
        }

        private List<Path> getRootPath() {
            return getListFilePath(ROOT_PATH);
        }

        private Map<Path, Long> calculatePathSize(List<Path> paths, Throwable t) {
            return paths.stream().collect(Collectors.toMap(f -> f, this::getSizeOfFile));
        }

        private void printMap(Map<Path, Long> map){
            map.forEach((k,v) -> {
                System.out.printf("File name is %s, Size: %d %n", k, v);
            });
        }

        private List<Path> getListFilePath(String url) {
            Stream<Path> pathStream = Stream.of();

            Path path = Paths.get(url);
            try {
                pathStream = Files.list(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return pathStream.collect(Collectors.toList());
        }
        private long getSizeOfFile(Path path) {
            try {
                return Files.size(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return 0;
        }

    }

}
