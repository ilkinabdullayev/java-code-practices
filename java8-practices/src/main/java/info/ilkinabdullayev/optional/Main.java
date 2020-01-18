package info.ilkinabdullayev.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String input = null;
        String test = Optional.ofNullable(input)
                .orElse("Test");
        System.out.println(test);

        input = "how are u world?";
        Optional.of(input)
                .map(i -> new Input(i))
                .ifPresent(System.out::println);


        Optional.of(input)
                .map(Input::new)
                .ifPresent(System.out::println);
    }
}
