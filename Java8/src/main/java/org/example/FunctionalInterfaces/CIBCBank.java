package org.example.FunctionalInterfaces;

public interface CIBCBank {

  void m3();

  default void cibc_m1() {
    System.out.println("Default method m1()");
  }

  default void m2() {
    System.out.println("Default method m2()-CIBC");
  }
}
