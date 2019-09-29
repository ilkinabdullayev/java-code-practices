package info.ilkinabdullayev.advanced;

import info.ilkinabdullayev.Person;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    private static final List<String> EMPTY_LIST = Collections.emptyList();
    private static final List<String> LIST = Arrays.asList("Bla", "Blo");


    private static final List<String> LIST1 = Arrays.asList("Ilkin", "Hello", "Ilkin");

    private static final List<Person> LIST_PERSON = Collections.EMPTY_LIST;


    public static void main(String[] args) {
        Predicate<Integer> predicateGreater5 = n -> n > 5;
        Predicate<Integer> predicateLess20 = n -> n < 20;

        boolean test = predicateGreater5.and(predicateLess20).negate().test(15);
        boolean test2 = predicateGreater5.and(predicateLess20).negate().test(15);

        System.out.println(test);
    }

    private static void test() {
        BiFunction<Integer, List<Person>, List<Person>> byId =
                (id, persons) -> {
                    return persons.stream()
                            .filter(person -> person.getId() == id)
                            .collect(Collectors.toList());
                };

        BiFunction<String, List<Person>, List<Person>> byName =
                (name, persons) -> {
                    return persons.stream()
                            .filter(person -> person.getName().equals(name))
                            .collect(Collectors.toList());
                };


        Function<List<Person>, List<Person>> sortById =
                persons -> {
                    return persons.stream()
                            .filter(Objects::nonNull)
                            .sorted(Comparator.comparing(Person::getId))
                            .collect(Collectors.toList());
                };

        Person person = sortById.apply(LIST_PERSON).stream().findFirst().orElseThrow(() -> new RuntimeException("No Person"));


        Function<List<Person>, Optional<Person>> findFirstFunction =
                persons -> {
                    return persons.stream()
                            .filter(Objects::nonNull)
                            .findFirst();
                };


        Function<List<Person>, Optional<Person>> newest = findFirstFunction.compose(sortById);


        BiFunction<String, List<Person>, Optional<Person>> newestByName = byName.andThen(newest);
    }

    private static String generateTime(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli() + "";
    }

    private static void test3() {
        Function<LocalDateTime, String> generateTimeFunction = Main::generateTime;
        Function<String, String> UUIDgeneratorFunction = text -> text + "-" + UUID.randomUUID().toString();


        String id = UUIDgeneratorFunction.apply(generateTimeFunction.apply(LocalDateTime.now()));
        System.out.println(id);

        id = UUIDgeneratorFunction.compose(generateTimeFunction).apply(LocalDateTime.now());
        System.out.println(id);

        id  = generateTimeFunction.andThen(UUIDgeneratorFunction).apply(LocalDateTime.now());
        System.out.println(id);
    }

    public static void test1() {
        boolean matched = EMPTY_LIST.stream().anyMatch(f -> f.contains("a"));
        System.out.println("EMPTY_LIST anyMatch: " + matched);

        matched = LIST.stream().anyMatch(f -> f.contains("a"));
        System.out.println("LIST anyMatch: " + matched);
        ////////////////////
        System.out.println("////////////////////");
        ////////////////////
        matched = EMPTY_LIST.stream().allMatch(f -> f.contains("a"));
        System.out.println("EMPTY_LIST allMatch: " + matched);

        matched = LIST.stream().allMatch(f -> f.contains("a"));
        System.out.println("LIST allMatch: " + matched);
        ////////////////////
        System.out.println("////////////////////");
        ////////////////////
        matched = EMPTY_LIST.stream().noneMatch(f -> f.contains("a"));
        System.out.println("EMPTY_LIST noneMatch: " + matched);

        matched = LIST.stream().noneMatch(f -> f.contains("a"));
        System.out.println("LIST noneMatch: " + matched);
    }

    public static void test2() {
        String a = LIST_PERSON.stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(f -> f.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.println(a.equals(""));


//        LIST1.stream()
//                .collect(Collectors.groupingBy(
//                        s -> s,
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(f -> f.getValue() > 1)
//                .forEach(System.out::println);
    }
}
