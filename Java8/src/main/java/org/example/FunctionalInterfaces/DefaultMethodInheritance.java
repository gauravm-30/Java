package org.example.FunctionalInterfaces;

// org.example.FunctionalInterfaces.DefaultMethodInheritance inherits unrelated defaults for m2()
// from types
// org.example.FunctionalInterfaces.CIBCBank and org.example.FunctionalInterfaces.RBCBank

/*
* Inside the method, we see RBCBank.super.m2().
RBCBank.super refers to the default implementation of the method m2() provided by the RBCBank interface.
By calling super.m2(), the implementing class (if any) will use this default implementation.
* */
class DefaultMethodInheritance implements CIBCBank, RBCBank {

  public static void createObject() {
    CIBCBank b1 = new DefaultMethodInheritance();
    b1.m2();
  }

  public static void createObjectV2() {
    RBCBank b1 = new DefaultMethodInheritance();
    b1.m2();
  }

  protected void m4() {}

  @Override
  public void m3() {}

  // Now we can use it like this way if we want.
  @Override
  public void m2() {
    RBCBank.super.m2();
  }
}
