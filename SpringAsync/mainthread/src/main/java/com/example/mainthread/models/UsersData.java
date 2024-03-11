package com.example.mainthread.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersData {

    private long id;
    private String name;
    private String email;
    private String country;
    private int age;
}
