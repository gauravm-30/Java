package org.example.FunctionalInterfaces;

// org.example.FunctionalInterfaces.DefaultMethodInheritance inherits unrelated defaults for m2()
// from types
// org.example.FunctionalInterfaces.CIBCBank and org.example.FunctionalInterfaces.RBCBank

public class DefaultMethodInheritance implements CIBCBank, RBCBank {

  // Now we can use it like this way if we want.
  @Override
  public void m2() {
    RBCBank.super.m2();
  }

  public static void createObject() {
    CIBCBank b1 = new DefaultMethodInheritance();
    b1.m2();
  }
}
