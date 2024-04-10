package com.example.streamdata.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int deptId;

    String deptName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Dept_Id")
    List<Employee> employees;
}
