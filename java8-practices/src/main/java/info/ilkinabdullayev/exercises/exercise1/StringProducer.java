package info.ilkinabdullayev.exercises.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringProducer {

    private static List<String> BLAS = Arrays.asList("TEST", "TEST1");

    private static String getMessage(String baseMessage) {
        final StringBuilder sb = new StringBuilder();

        sb.append(baseMessage).append('\n');
        for (String ec : BLAS) {
            sb.append('\t').append(ec).append('\n');
        }

        return sb.toString();
    }

    private static String collector(String baseMessage) {
        return baseMessage + BLAS
                .stream()
                .collect(Collectors.joining("\n\t", "\n\t", "\n"));
    }


    public static void main(String[] args) {
        System.out.println(getMessage("Xiyar"));
        System.out.println(collector("Xiyar"));
        System.out.println("Tets");
    }

}
