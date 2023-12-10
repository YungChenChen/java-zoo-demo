package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Animal {





    @Id
    @GeneratedValue

    private Long id;
    private String name;
    private int age;
    private String healthStatus;

//    public Animal(String name, int age, String healthStatus) {
//
//        this.name = name;
//        this.age = age;
//        this.healthStatus = healthStatus;
//    }

    public Animal() {

    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }


//    public void displayInfo() {
//        System.out.println("Animal: " + name + ", Age: " + age + ", Health: " +
//                healthStatus); }
//
}

