package org.example.FunctionalInterfaces;

public interface RBCBank {

  void m3();

  default void rbc_m1() {
    System.out.println("Default method m1()");
  }

  default void m2() {
    System.out.println("Default method m2()-RBC");
  }
}
