package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
public class Student{
    @Id
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String rollNumber;
}