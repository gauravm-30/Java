package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    System.out.println("Java 8 Stream API");
    //    List<Integer> numList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, -123);

    //    printAllEvenNumbersFromList(numList);
    //    System.out.println();
    //    findNumsStartingWithOne(numList);

    //    List<Integer> duplicateNumsList = Arrays.asList(10, 1, 5, 15, 10, 45, 32, 45);
    //    printDuplicateElement(duplicateNumsList);

    printDuplicateElementUsingMapJava8();
  }

  private static void printAllEvenNumbersFromList(List<Integer> numList) {
    System.out.println("Printing all even numbers from list");
    numList.stream().filter(num -> num % 2 == 0).forEach(even -> System.out.print(even + ", "));
  }

  private static void findNumsStartingWithOne(List<Integer> numList) {
    // first get convert numList into stringList
    Stream<String> nums = numList.stream().map(num -> num.toString());

    // Also we can convert into the stringList like this
    /*
    String stringList=numList.stream().map(num->num+"");
     */

    // apply filter then
    nums.filter(num -> num.startsWith("1")).forEach(n -> System.out.print(n + ", "));

    System.out.println();

    /*
    Important :what if numbers consist both positive and negative numbers
     */
    numList.stream()
        .map(num -> num.toString())
        .filter(num -> num.startsWith("1") || num.startsWith("-1"))
        .forEach(n -> System.out.print(n + ", "));
  }

  private static void printDuplicateElement(List<Integer> numList) {
    Set<Integer> seen = new HashSet<>();
    List<Integer> duplicates = new ArrayList<>();
    for (int i : numList) {
      if (seen.contains(i)) {
        duplicates.add(i);
      } else {
        seen.add(i);
      }
    }
    duplicates.forEach(duplicate -> System.out.print(duplicate + ", "));
    System.out.println();
    Set<Integer> newSeen = new HashSet<>();
    numList.stream()
        .filter(num -> !newSeen.add(num))
        .forEach(duplicate -> System.out.print(duplicate + ", "));
  }

  private static void printDuplicateElementUsingMapJava8() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    /*
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())):

    This part of the code performs the following steps:
    It collects the stream elements into a map.
    The groupingBy collector groups the elements based on their identity (i.e., the actual value of the element).
    The counting() collector counts the occurrences of each element.
    The result is a map where keys are the distinct elements from the stream, and values are the counts of each element.
            */
    /*
        * Collectors.groupingBy(Function.identity(), Collectors.counting()):
    This part of the code performs the following steps:
    It groups the elements based on their identity (i.e., the actual value of the element).
    The groupingBy collector takes two arguments:
    The first argument is the classifier function, which determines how elements are grouped. In our case, Function.identity() returns the element itself as the key for grouping.
    The second argument is the downstream collector, which specifies how to aggregate the grouped elements. Here, we use Collectors.counting().
    The counting() collector counts the occurrences of each element within each group.
    The result is a map where keys are the distinct elements from the stream, and values are the counts of each element (represented as Long).
    */

    var freqMap =
        elements.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    /*
    We cannot stream on Map directly , first we need to get the Set of entries of map then we can stream into it.
     */
    Set<Map.Entry<Integer, Long>> entries = freqMap.entrySet();

    // Stream into each entry of entries
    entries.stream()
        .filter(entry -> entry.getValue() > 1)
        .forEach(entry -> System.out.print(entry.getKey() + ", "));

    System.out.println("Frequency Map: " + freqMap);
  }
}
