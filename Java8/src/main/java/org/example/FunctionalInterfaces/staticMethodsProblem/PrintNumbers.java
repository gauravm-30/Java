package org.example.FunctionalInterfaces.staticMethodsProblem;

public class PrintNumbers implements PrintNumFInterface1, PrintNumFInterface2 {
  @Override
  public void add() {
    System.out.println(1 + 2);
  }

  public static void main(String[] args) {

    // Since it is class level method so no problem exists if static method with same name is
    // defined in two different interface

    // By default, static methods are not available in implementing classes; you need to call
    // them using `InterfaceName.methodName()`.

    PrintNumFInterface1.printNumbers();
    PrintNumFInterface2.printNumbers();
  }
}
