package info.ilkinabdullayev.advanced.lesson2;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        User john = new User("John", 30);
        john.getRating().add(new Review(5, ""));
        john.getRating().add(new Review(3, "not bad"));

        User julie = new User("Julie", 35);
        john.getRating().add(new Review(4, "great!"));
        john.getRating().add(new Review(2, "terrible experience"));
        john.getRating().add(new Review(4, ""));

        List<User> users = Arrays.asList(john, julie);

        Rating avr = users.stream()
                .map(User::getRating)
                .reduce(Rating.EMPTY, Rating::average);
        System.out.println("Result is: " + avr.points);
    }

}
