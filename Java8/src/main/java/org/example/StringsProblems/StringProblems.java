package org.example.StringsProblems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringProblems {
  public static void main(String[] args) {
    reverseStringV3();
  }

  private static void findFirstNonRepeatedChar() {
    // We can't apply stream operation on it because it is not chars array.
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

  private static void concatenateTwoStreams() {
    List<String> streamList1 = Arrays.asList("Java", "8");
    List<String> streamList2 = Arrays.asList("explained", "through", "programs");

    Stream<String> concatStream = Stream.concat(streamList1.stream(), streamList2.stream());

    concatStream.forEach(input -> System.out.print(input + " "));
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

  public static void reverseStringV1() {
    String original = "Aniruddh";
    String reversed = new StringBuilder(original).reverse().toString();
    System.out.println(reversed); // Output: hddurinA
  }

  public static void reverseStringV2() {
    String s1 = "Gaurav";
    var m1 =
        s1.chars().mapToObj(ele -> String.valueOf((char) ele)).reduce("", (s2, s3) -> (s3 + s2));
  }

  public static void reverseStringV3() {
    String s1 = "Gaurav";
    var m1 = s1.toCharArray();
    int i = 0;
    int j = m1.length - 1;
    while (i < j) {
      swap(m1, i, j);
      i++;
      j--;
    }
    String s2 = new String(m1);
    System.out.println("s2 = " + s2);
  }

  private static void swap(char[] m1, int i, int j) {
    char temp = m1[i];
    m1[i] = m1[j];
    m1[j] = temp;
  }

  public static void findVowelsCount() {
    String s1 = "abcAAdeiu";
    Predicate<Character> isVowels =
        (ch) -> {
          if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
          }
          return false;
        };
    long vowels =
        s1.chars().mapToObj(ch -> Character.toLowerCase((char) ch)).filter(isVowels).count();
  }
}
