package info.ilkinabdullayev.mooc.crap1;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Main1 {

    private long a1 = 3;

    public static void main(String[] args) throws IOException {
        List<String> names = new ArrayList<>();
        names.add("Ilkin");
        names.add("Alma");
        names.add("Petr");
        names.add("David");
        names.add("Agac");
        names.removeIf(f -> f.startsWith("A"));

        names.replaceAll(String::toUpperCase);

        names.sort((c1, c2) -> c1.length() - c2.length());
        names.sort(String::compareTo);
        names.sort(Comparator.reverseOrder());
        names.sort(Comparator.naturalOrder());

        Collections.sort(names, Comparator.reverseOrder());

        names.forEach(System.out::println);
    }

    void test() {
        long a = 3;
        Consumer<String> consumer = c -> {
            a1++; //this.a1++;
        };

        consumer = c -> this.expire(null,0);

    }

    void expire(File root, long before) {
        root.listFiles(f -> f.lastModified() < before);
    }
}
