package org.example;

import java.util.Arrays;

public class Sorting {
  public static void runSorting() {
    int[] nums = {1, 2, 3, 4, 5};
    getIntegerArr(nums);
  }

  //  Certainly! Let's break down the expression `personList.toArray(size -> new Person[size]);` and
  // understand how it works:
  //
  // 1. **`size -> new Person[size]`**:
  //   - This part is a **lambda expression**.
  //   - The lambda expression takes an integer argument (which represents the desired size of the
  // resulting array) and returns a new `Person[]` array of that size.
  //   - Here's how it works step by step:
  //     - When you call `toArray(size -> new Person[size])`, the `size` parameter represents the
  // number of elements in the list (`personList`).
  //     - The lambda expression creates a new `Person[]` array with the specified size (`size`).
  //     - Each element in the array is initialized to `null` (since we haven't provided any
  // specific values).
  //
  // 2. **`personList.toArray(...)`**:
  //   - The `toArray()` method is called on the `personList`.
  //   - It converts the list of `Person` objects (`personList`) into an array of `Person`.
  //   - The method expects a single argument, which is a function that maps each element of the
  // list to the corresponding element in the resulting array.
  //
  // 3. **Putting It All Together**:
  //   - The entire expression `personList.toArray(size -> new Person[size])`:
  //     - Takes the size of the list (`personList`).
  //     - Creates a new `Person[]` array with that size.
  //     - Initializes each element in the array to `null`and then initialize with the element
  //     - Returns the resulting array.
  //
  // In summary, the expression converts the `personList` (a list of `Person` objects) into an array
  // of `Person`. The size of the resulting array is determined by the number of elements in the
  // list.
  //

  public static void getIntegerArr(int[] nums) {
    Integer[] arr = Arrays.stream(nums).boxed().toArray(size -> new Integer[size]);
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[i] = " + arr[i]);
    }
  }
}
