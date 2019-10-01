package info.ilkinabdullayev.advanced.lesson1;

import info.ilkinabdullayev.advanced.lesson1.annotations.ViewName;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;

        Arrays.asList(
                studentClass.getDeclaredFields()
        ).stream()
                .forEach(field -> {
                    ViewName[] viewNames = field.getAnnotationsByType(ViewName.class);
                    Arrays.asList(viewNames).stream().forEach(System.out::println);
                });
    }
}
