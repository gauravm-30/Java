package org.example.FunctionalInterfaces;

public class RunFunctionaInterface {
  static int age = 25;
  int m1;
  int m2;

  public RunFunctionaInterface(int m1, int m2) {
    this.m1 = m1;
    this.m2 = m2;
  }

  public static void main(String[] args) {
    DefaultMethodInheritance.createObjectV2();
    RunFunctionaInterface runFunctionaInterface = new RunFunctionaInterface(10, 20);

    int f1 = 23;
    AddFInterface addFInterface =
        () -> {
          // make the copy of the local variable
          int f3 = f1;
          System.out.println(age);
          System.out.println(age + 1);
          // we can't change the local variable value
          System.out.println(f1);
          System.out.println(f3++);
          System.out.println(runFunctionaInterface.m1);
          runFunctionaInterface.m1 = 30;
          System.out.println(runFunctionaInterface.m1);
        };

    addFInterface.add();

    System.out.println(runFunctionaInterface.m1);
  }
}
