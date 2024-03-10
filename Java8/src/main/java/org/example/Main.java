package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
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

    List<Integer> duplicateNumsList = Arrays.asList(10, 1, 5, 15, 10, 45, 32, 45);
    //    printDuplicateElement(duplicateNumsList);

    //    printDuplicateElementUsingMapJava8();

    //    findFirstElementOfList();

    //    findMaxValue();

    //    findFirstNonRepeatedChar();
    //
    //    findFirstRepeatedChar();

    //    sortList();

    //    sortListDesc();

    //    isElementAppearsTwice();
    //    getCurrentDateAndTime();

    //    concatenateTwoStreams();

    //    performCubeAndReturnGreaterThan50();
    //    sortAndConvertIntoStream();

    //    convertIntoUpperCase();

    //    StreamOnObject.convertNotesIntoMap();
    //    countInputLength();

    //    removeWhiteSpaceAndDigitIfPresentIn();
    //    findDuplicateElementWithCount();
    //    findMaxElement();

    findCountOfInput();
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

  private static void printDuplicateElementUsingSetJava8(List<Integer> numList) {
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

    // Now newSeen will contain the element which are unique
    System.out.println(newSeen.toString());
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

  private static void findFirstElementOfList() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);

    elements.stream().findFirst().ifPresent(System.out::println);
  }

  private static void findTotalElementsCount() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    var count = elements.stream().count();
    System.out.println(count);
  }

  private static void findMaxValue() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    elements.stream().max(Integer::compareTo).ifPresent(System.out::println);

    var maxElement =
        elements.stream().max(Comparator.comparing(element -> Integer.valueOf(element))).get();
    System.out.println(maxElement);
  }

  private static void findFirstNonRepeatedChar() {
    String input = " Java stream are  really  jelly helpful ";

    /*
    input.chars() gives the IntStream i.e.
    74, 97, 118, 97, 32, 97, 114, 116, 105, 99, 108, 101, 115, 32, 97, 114, 101, 32, 97, 119, 101, 115, 111, 109, 101,

    input.chars().mapToObj(ch->(char)ch)
    J, a, v, a,  , a, r, t, i, c, l, e, s,  , a, r, e,  , a, w, e, s, o, m, e,
    * */

    var m1 =
        input
            .chars()
            .mapToObj(ch -> (char) ch) // get stream of characters
            .map(
                character ->
                    Character.toLowerCase(
                        character)) // convert them to either lowercase or upper case otherwise J
            // and j will treated as different letter
            .filter(
                ch ->
                    !Character.isWhitespace(
                        ch)) // filter out the whitespace character in the string
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors
                        .counting())); // we use the LinkedHashMap to maintain the order in which
    // they are  already in

    m1.entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .findFirst()
        .ifPresent(entry -> System.out.println(entry.getKey()));
  }

  private static void findFirstRepeatedChar() {
    String input = "Welcome to java world";

    var freqMap =
        input
            .chars()
            .mapToObj(ch -> Character.toLowerCase((char) ch))
            .filter(ch -> !Character.isWhitespace(ch))
            .collect(
                Collectors.groupingBy(
                    Function.identity(), () -> new LinkedHashMap<>(), Collectors.counting()));

    freqMap.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .findFirst()
        .ifPresent(entry -> System.out.println(entry.getKey() + " "));
  }

  private static void sortList() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    elements.stream().sorted().forEach(element -> System.out.print(element + ", "));
  }

  private static void sortListDesc() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    elements.stream()
        .sorted(Collections.reverseOrder())
        .forEach(element -> System.out.print(element + ", "));
  }

  private static void isElementAppearsTwice() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);
    List<Integer> uniqueElem = Arrays.asList(1, 2, 3, 4);

    var freqMap =
        uniqueElem.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // anyMatch , allMatch
    var isAnyElementAppearedTwice =
        freqMap.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);

    System.out.println(isAnyElementAppearedTwice);
  }

  private static void getCurrentDateAndTime() {
    System.out.println("Java Date And Time " + LocalDate.now() + "==" + LocalTime.now());
  }

  private static void concatenateTwoStreams() {
    List<String> streamList1 = Arrays.asList("Java", "8");
    List<String> streamList2 = Arrays.asList("explained", "through", "programs");

    Stream<String> concatStream = Stream.concat(streamList1.stream(), streamList2.stream());

    concatStream.forEach(input -> System.out.print(input + " "));
  }

  private static void performCubeAndReturnGreaterThan50() {
    List<Integer> elements = Arrays.asList(5, 2, 3, 7, 1, 3, 4, 5, 9);
    elements.stream()
        .map(ele -> ele * ele * ele)
        .filter(ele -> ele > 50)
        .forEach(ele -> System.out.print(ele + ", "));
  }

  private static void sortAndConvertIntoStream() {
    int[] elements = {5, 2, 3, 7, 1, 3, 4, 5, 9};
    Arrays.sort(elements);
    Arrays.stream(elements).forEach(ele -> System.out.print(ele + ", "));
  }

  private static void convertIntoUpperCase() {
    List<String> input = Arrays.asList("Welcome", "To", "java", "world");
    input.stream().map(ele -> ele.toUpperCase()).forEach(ele -> System.out.println(ele + ", "));
  }

  private static void countInputLength() {
    List<String> stringInput = Arrays.asList("Welcome", "to", "java", "world");
    stringInput.stream().forEach(stringValue -> System.out.println(stringValue.length()));
    var countStringMap =
        stringInput.stream()
            .collect(
                Collectors.toMap(
                    stringValue -> stringValue,
                    stringValue -> stringValue.length(),
                    (oldVal, newVal) -> oldVal,
                    LinkedHashMap::new));

    countStringMap.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
  }

  private static void removeWhiteSpaceAndDigitIfPresentIn() {
    List<String> stringList = Arrays.asList(" unfiltered ", "withDigit123", " white space ");

    List<String> filteredList =
        stringList.stream()
            .map(String::toUpperCase) // Convert to uppercase (optional)
            .map(s -> s.replaceAll("\\d", "")) // Remove digits
            .map(s -> s.replace(" ", "")) // Remove whitespace
            .collect(Collectors.toList());

    filteredList.forEach(System.out::println);
  }

  private static void findDuplicateElementWithCount() {
    List<String> input = Arrays.asList("Welcome", "To", "java", "world", "java", "java", "to");

    var countMap =
        input.stream()
            .map(ele -> ele.toLowerCase())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    countMap.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .forEach(entry -> System.out.println(entry.getKey()));
  }

  private static void findMaxElement() {
    int[] arr = {1, 7, 3, 9, 23, 90};

    var maxValue = Arrays.stream(arr).max().getAsInt();
    System.out.println(maxValue);
  }

  private static void findCountOfInput() {
    String input = "ASKJNFWFWLnldsLWVNWML";

    var charArr =
        input
            .toLowerCase()
            .chars()
            .mapToObj(ele -> (char) ele)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));

    charArr.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + ", " + entry.getValue()));
  }
}
