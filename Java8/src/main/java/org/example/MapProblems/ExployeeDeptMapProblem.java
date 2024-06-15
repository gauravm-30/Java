package org.example.MapProblems;

import java.util.*;
import java.util.stream.Collectors;

public class ExployeeDeptMapProblem {

  class Department {
    private int deptId;
    private String dName;

    // Constructors, getters, and setters...
  }

  class Employee {
    private int empId;
    private String eName;
    private int deptId;

    // Constructors, getters, and setters...
  }

  public class EmployeeGroupingExample {
    public static void main(String[] args) {
      List<Employee> employeeList = new ArrayList<>(); // Your list of employees

      // Assuming you have a list of employees (employeeList)
      //            Map<Department, Set<Employee>> employeeMap = employeeList.stream()
      //                    .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new,
      // Collectors.toSet()));

      System.out.println("Employees grouped by department:");
      //            employeeMap.forEach((Department key, Set<Employee> empSet) ->
      //                    System.out.println(key.getDName() + ": " + empSet));
    }
  }
}
