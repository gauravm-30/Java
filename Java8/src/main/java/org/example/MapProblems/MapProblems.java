package org.example.MapProblems;

import java.util.*;

public class MapProblems {

  public static void main(String[] args) {
    printFrequencyMapFromVer1(); // using map
    printFrequencyMapFromVer2(); // using map
    printFrequencyMapFromVer3(); // using loop
  }

  public static void printFrequencyMapFromVer1() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);

    // Create a frequency map using a loop
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (Integer element : elements) {
      /*          For each element, it checks whether it already exists in the frequencyMap.
      If it exists, it increments the existing count by 1.
      If it doesn’t exist, it initializes the count with 0 and then adds 1.
      This way, the frequencyMap keeps track of the occurrences of each element
      .*/
      frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entrySet : frequencyMap.entrySet()) {
      System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
    }
    System.out.println("Frequency Map: " + frequencyMap);
  }

  public static void printFrequencyMapFromVer2() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);

    // Create a frequency map using a loop
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (Integer element : elements) {
      if (!frequencyMap.containsKey(element)) {
        frequencyMap.put(element, 1);
      } else {
        frequencyMap.put(element, frequencyMap.get(element) + 1);
      }
    }

    for (Map.Entry<Integer, Integer> entrySet : frequencyMap.entrySet()) {
      System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
    }
    System.out.println("Frequency Map: " + frequencyMap);
  }

  // TC -O(n^2)
  // SC -O(n)

  public static void printFrequencyMapFromVer3() {
    List<Integer> elements = Arrays.asList(1, 2, 3, 2, 1, 3, 4, 5, 4);

    boolean[] visited = new boolean[elements.size()];
    Arrays.fill(visited, false);

    System.out.println();
    // Traverse through each elements
    for (int i = 0; i < elements.size() - 1; i++) {
      // ignore the element if already visited
      if (visited[i]) continue;

      int count = 1;
      // Comparing the element with the other next elements
      for (int j = i + 1; j < elements.size(); j++) {
        if (elements.get(i) == elements.get(j)) {
          // put visited to true whenever find the same element and increase the count
          visited[j] = true;
          count++;
        }
      }
      System.out.print(elements.get(i) + " " + count);
    }
  }
}
