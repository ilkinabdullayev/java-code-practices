/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 1 homework
 */
package info.ilkinabdullayev.exercises.moc1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson1 {
  /**
   * Run the exercises to ensure we got the right answers
   */
  public void runExercises() {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
  }

  /**
   * All exercises should be completed using Lambda expressions and the new
   * methods added to JDK 8 where appropriate. There is no need to use an
   * explicit loop in any of the code. Use method references rather than full
   * lambda expressions wherever possible.
   */
  /**
   * Exercise 1
   *
   * Create a string that consists of the first letter of each word in the list
   * of Strings provided.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

    //First way
    StringBuilder stringBuilder = new StringBuilder();
    list.forEach(s -> stringBuilder.append(s.charAt(0)));

    //Second Way
    String joinedNewWord = list.stream()
            .filter(f -> f != null || !f.isEmpty())
            .map(m -> String.valueOf(m.charAt(0)))
            .collect(Collectors.joining());

    System.out.println("Joined new word with StringBuilder:" + stringBuilder.toString());
    System.out.println("Joined new word with Streams collect:" + joinedNewWord);
  }

  /**
   * Exercise 2
   *
   * Remove the words that have odd lengths from the list.
   */
  private void exercise2() {
    List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

   list.removeIf(f -> f.length() % 2 != 0);
   list.forEach(System.out::println);
  }

  /**
   * Exercise 3
   *
   * Replace every word in the list with its upper case equivalent.
   */
  private void exercise3() {
    List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    list.replaceAll(String::toUpperCase);
    list.forEach(System.out::println);
  }

  /**
   * Exercise 4
   *
   * Convert every key-value pair of the map into a string and append them all
   * into a single string, in iteration order.
   */
  private void exercise4() {
    Map<String, Integer> map = new TreeMap<>();
    map.put("c", 3);
    map.put("b", 2);
    map.put("a", 1);

    StringBuilder builder = new StringBuilder();
    map.forEach((k, v) -> builder.append(k).append(v));
    System.out.println(builder.toString());
  }

  /**
   * Exercise 5
   *
   * Create a new thread that prints the numbers from the list.
   */
  private void exercise5() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    new Thread(() -> list.forEach(System.out::println)).start();
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Lesson1 lesson = new Lesson1();
    lesson.runExercises();
  }
}
