package org.example.FunctionalInterfaces.staticMethodsProblem;

@FunctionalInterface
public interface PrintNumFInterface1 {
  void add();

  static void printNumbers() {
    for (int i = 0; i < 10; i++) {
      System.out.println("i = " + i);
    }
  }
}
