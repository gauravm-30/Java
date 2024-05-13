package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionProblems {

  // Convert int[] into List<Integer> using java 8 streams

  public static void convertIntoList() {
    int[] arr = {1, 2, 3, 4, 5};

    var intStream = Arrays.stream(arr); // returns the int stream
    var intStream2 = Arrays.stream(arr); // returns the int stream

    // converting into ArrayList
    // .boxed(): The boxed() method converts each primitive int value in the stream to its
    // corresponding wrapper class Integer. In other words, it boxes the int values into Integer
    // objects.
    List<Integer> integerList = intStream.boxed().collect(Collectors.toList());
    List<Integer> integerList2 =
        intStream2.mapToObj(ele -> (Integer) ele).collect(Collectors.toList());
    System.out.println(integerList.toString());

    // converting into primitive integer array
    int[] integerArr = integerList.stream().mapToInt(ele -> ele).toArray();
    for (int i = 0; i < integerArr.length; i++) {
      System.out.println(integerArr[i]);
    }
  }
}
