package org.example.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceStream {
  // reduce function is used for aggregation
  public static void main(String[] args) {
    findSum();
    findMax();
    findProduct();
    findMaxLengthString();
    concatenateStrings();
  }

  private static void findMaxLengthString() {
    List<String> words = Arrays.asList("Gaurav", "GeeksForGeeks", "Leetcode", "Microservices");
    String word = words.stream().reduce("", (s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
    System.out.println("word = " + word);
  }

  private static void findProduct() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int product = numbers.stream().reduce(1, (a, b) -> a * b);
    System.out.println("product = " + product);
  }

  private static void findMax() {
    List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 15);
    int max = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
    System.out.println("Max value: " + max); // Output: Max value: 30
  }

  private static void concatenateStrings() {
    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    String s1 =
        letters.stream().reduce("", (partialString, nextString) -> partialString + nextString);
    System.out.println("s1 = " + s1);
  }

  private static void findSum() {
    /*

    *   <pre>{@code
    *     T result = identity;
    *     for (T element : this stream)
    *         result = accumulator.apply(result, element)
    *     return result;
    * }</pre>
    * */

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int sum = numbers.stream().reduce(0, (a, b) -> a + b);
    System.out.println("Sum: " + sum); // Output: Sum: 15

    // OR
    int sum2 = numbers.stream().mapToInt(ele -> ele).sum();
  }
}
