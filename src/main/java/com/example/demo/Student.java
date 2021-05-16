package com.example.demo;

import javax.persistence.*;

//@MappedSuperclass
//public class Person {
//@Column(name = "name")
@Entity
//@Table(name = "Datensatz")
public class Student {
        private String name;
        private int age;
        private String PhoneNumber;
        private Long id;

    public Student(String name) {
        this.name = name;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

}


