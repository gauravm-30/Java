package org.example.FunctionalInterfaces;

public class StaticAndDefaultMethodsPurpose {

  /*
      * Certainly! In Java 8, **default methods** and **static methods** were introduced in interfaces to enhance their functionality. Let's explore each of these features:

  1. **Default Methods**:
     - A default method allows you to add a new method to an existing interface without affecting the implementing classes.
     - Key points about default methods:
       - It uses the `default` modifier.
       - It must have a complete method definition (a dummy body).
       - Implementing classes are not required to override a default method, but they can if needed.
     - **Reason for Introducing Default Methods**:
       - Prior to Java 8, if an existing interface was implemented by many classes, adding a new method to that interface would require all implementing classes to provide an implementation for the new method.
       - Default methods address this issue by allowing you to add new features to an interface without breaking existing code.
     - Example of a default method:
       ```java
       interface MyInterface {
           default void display() {
               System.out.println("This is a dummy definition");
           }
       }

       public class DefaultMethodExample implements MyInterface {
           public static void main(String[] args) {
               DefaultMethodExample obj = new DefaultMethodExample();
               obj.display();
           }
       }
       // Output: This is a dummy definition
       ```

  2. **Static Methods**:
     - Java 8 also supports static methods within an interface.
     - Key points about static methods:
       - Method body should be provided at the time of declaration.
       - Static methods cannot be overridden in implementing classes.
       - They use the `static` modifier.
       - By default, static methods are not available in implementing classes; you need to call them using `InterfaceName.methodName()`.
     - Example of a static method:
       ```java
       interface MyInterface {
           static void display() {
               System.out.println("This is a static definition");
           }
       }

       public class StaticMethodExample implements MyInterface {
           public static void main(String[] args) {
               MyInterface.display();
           }
       }
       // Output: This is a static definition
       ```

  In summary, default methods allow you to evolve interfaces without breaking existing implementations, while static methods provide utility methods within interfaces. These features enhance the flexibility and expressiveness of Java interfaces! 😊🚀¹²³⁴

  Source: Conversation with Copilot, 26/5/2024
  (1) Static Methods & Default Methods In Java 8 | Programmerbay. https://programmerbay.com/static-methods-default-methods-in-java-8/.
  (2) Java 8 Default and Static Methods in Interfaces - Websparrow. https://websparrow.org/java/java-8-default-and-static-methods-in-interfaces.
  (3) Static and Default Methods in Interfaces in Java | Baeldung. https://www.baeldung.com/java-static-default-methods.
  (4) Default Methods In Java 8 - GeeksforGeeks. https://www.geeksforgeeks.org/default-methods-java/.
      * */
}
