package org.example.FunctionalInterfaces.staticMethodsProblem;

@FunctionalInterface
public interface PrintNumFInterface2 {
  void add();

  static void printNumbers() {
    for (int i = 0; i < 10; i++) {
      System.out.println("i = " + i);
    }
  }
}
