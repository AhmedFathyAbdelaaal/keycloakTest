package com.example.keycloaktwo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//Our employee entity, we specify that it is an entity, with no args and it has Data
@Entity
@NoArgsConstructor
@Data
public class Employee {

    //our Id variable
    @Id
    @GeneratedValue
    private int id;

    // our string variable name
    private String name;

    //our double variable salary
    private double salary;

    // a constructor.
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

}
