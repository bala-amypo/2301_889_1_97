package com.example.demo.entity;

public class Student{
    @Id
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String rollNumber;
}