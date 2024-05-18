package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    System.out.println("Java 8 Stream API");
    List<Integer> numList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, -123);
    sortNumbers();
    //    Sorting.runSorting();
    //    ConversionProblems.convertIntoList();
    //    findMaxChar();

    //    Optional.ofNullable(notesList).orElseGet(Collections::emptyList) it is very important to
    // use optional
    //    printAllEvenNumbersFromList(numList);
    //    System.out.println();
    //    findNumsStartingWithOne(numList);

    //    List<Integer> duplicateNumsList = Arrays.asList(10, 1, 5, 15, 10, 45, 32, 45);
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

    //    findCountOfInput();
  }

  private static void printAllEvenNumbersFromList(List<Integer> numList) {
    System.out.println("Printing all even numbers from list");
    // predicate can be used directly into the filter as shown !!
    // Also one more point to be noted that if there exist the single statement  we can directly use
    // into the function.
    Predicate<Integer> p1 =
        (ele) -> {
          if (ele % 2 == 0) return true;
          return false;
        };
    numList.stream().filter(p1).forEach(even -> System.out.print(even + ", "));

    numList.stream().filter(num -> num % 2 == 0).forEach(even -> System.out.print(even + ", "));
  }

  private static void findNumsStartingWithOne(List<Integer> numList) {
    // we can also use this way
    //    UnaryOperator<Integer> convertToPositive=(element)->{
    //      if(element<0){
    //        element=element*(-1);
    //      }
    //      return element;
    //    };

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
    // Approach 1
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
    // Approach 2
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

    var countStringMap =
        elements.stream()
            .collect(
                Collectors.toMap(
                    (ele) -> ele, // key
                    ele -> 1, // value
                    (oldVal, newVal) ->
                        oldVal + newVal, // what to do if same key have different values
                    LinkedHashMap::new));

    var freqMap2 =
        elements.stream().collect(Collectors.groupingBy((ele) -> ele, Collectors.counting()));

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

  private static void findMaxElement() {
    int[] arr = {1, 7, 3, 9, 23, 90};

    var maxValue = Arrays.stream(arr).max().getAsInt();
    System.out.println(maxValue);
  }

  private static void convertPrimitiveIntIntoInteger_String() {
    int[] m1 = {1, 2, 3, 4, 5};
    // we get the stream for primitive types
    var sInt = Arrays.stream(m1);
    // Convert it into Stream<Integer>
    var sInteger = sInt.boxed();
    var sInteger2 = sInt.mapToObj((ele) -> Integer.valueOf(ele));

    var sString = sInt.mapToObj((ele) -> String.valueOf(ele));
    var sString2 = sInt.mapToObj((ele) -> ele + "");
  }

  private static void concatenateTwoStreamsFlatmap() {
    List<String> streamList1 = Arrays.asList("Java", "8");
    List<String> streamList2 = Arrays.asList("explained", "through", "programs");

    Stream<String> concatStream = Stream.concat(streamList1.stream(), streamList2.stream());

    concatStream.forEach(input -> System.out.print(input + " "));
  }

  private static void findMaxChar() {
    String input = "elcome to java orld";

    var characterStream =
        input
            .toLowerCase()
            .chars()
            .mapToObj(ele -> (char) ele)
            .filter(ch -> !Character.isWhitespace(ch));
    characterStream
        .max(Comparator.naturalOrder())
        .ifPresent((maxChar) -> System.out.println(maxChar));
  }

  // **
  private static void findSumOfAllNumbers() {
    List<Integer> arr = Arrays.asList(1, 2, 34, 5, 8);
    Integer sum = arr.stream().reduce((ele1, ele2) -> ele1 + ele2).get();
  }

  private static void sortNumbers() {
    List<Integer> arr = Arrays.asList(1, 2, 34, 5, 8);
    Comparator<Integer> sortReverseComparator =
        (e1, e2) -> {
          if (Objects.equals(e1, e2)) {
            return 0;
          } else if (e1 < e2) {
            return 1;
          } else return -1;
        };
    arr.stream().sorted(sortReverseComparator).forEach(System.out::println);
  }
}
