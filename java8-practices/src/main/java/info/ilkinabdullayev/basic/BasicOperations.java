package info.ilkinabdullayev.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicOperations {


    public static void main(String[] args) {
        /////Default Methods for Interfaces
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };

        double sqrtValue = formula.calculate(9);
        System.out.println(sqrtValue);


        /////Lambda expressions
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        names.forEach(System.out::println);


        /////Functional Interfaces

    }



}
