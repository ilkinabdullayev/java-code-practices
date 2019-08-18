package info.ilkinabdullayev.basic.lesson2;


import java.util.Arrays;
import java.util.List;

public class LambdaApp {


    public static void main(String[] args) {
        LambdaApp lambdaApp = new LambdaApp();

        Foo foo = (a, b) -> a + b;
        int result = foo.apply(3, 4);

        System.out.println(result);
        //
        List<Integer> sampleIntegers = Arrays.asList(
                2, 4, -3, 20, 10, 3
        );

        lambdaApp.checkNumbers(sampleIntegers, number -> number > 4);
        lambdaApp.checkNumbers2(sampleIntegers, (Integer number) -> number > 4);
        lambdaApp.checkNumbers2(sampleIntegers, (Integer number) -> number < 4);
        //
        List<String> sampleStrings = Arrays.asList(
                "David", "Andrea", "Lena", "Chris", "Petr"
        );

        Validator<String> stringValidator = s -> s.contains("e");
        lambdaApp.checkStrings(sampleStrings, stringValidator);
        //


        lambdaApp.checkList(sampleIntegers, number -> number > 4);
        lambdaApp.checkList(sampleIntegers, (Integer number) -> number > 4);
        lambdaApp.checkList(sampleIntegers, (Integer number) -> number < 4);
        lambdaApp.checkList(sampleStrings, s -> s.contains("e"));
    }

    public void checkNumbers(List<Integer> integerList, NumberValidator numberValidator) {
        for (Integer integer: integerList) {
            boolean isPassed = numberValidator.check(integer);
            if(isPassed) {
                System.out.println(integer + " passed from validation");
            }
        }
    }

    public void checkNumbers2(List<Integer> integerList, Validator<Integer> validator) {
        for (Integer integer: integerList) {
            boolean isPassed = validator.check(integer);
            if(isPassed) {
                System.out.println(integer + " passed from validation");
            }
        }
    }

    public void checkStrings(List<String> stringList, Validator<String> validator) {
        for (String phrase: stringList) {
            boolean isPassed = validator.check(phrase);
            if(isPassed) {
                System.out.println(phrase + " passed from validation");
            }
        }
    }

    public <T> void checkList(List<T> list, Validator<T> validator) {
        for (T item: list) {
            boolean isPassed = validator.check(item);
            if(isPassed) {
                System.out.println(item + " passed from validation");
            }
        }
    }

}

