package org.example.FunctionalInterfaces;

@FunctionalInterface
public interface AddFInterface {
  void add();

  static void printNumbers() {
    for (int i = 0; i < 10; i++) {
      System.out.println("i = " + i);
    }
  }
}
