package com.example.streamdata.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int empId;

    String empName;

}
