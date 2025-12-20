package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;


@Entity
@Table(name = "students",
uniqueConstraints = {
 @UniqueConstraint(columnNames = "email"),
 @UniqueConstraint(columnNames = "rollNumber")
})

public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String rollNumber;

    
    public Student(Long id, String name, String email, String rollNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollNumber = rollNumber;
    }
    public Student() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
}
