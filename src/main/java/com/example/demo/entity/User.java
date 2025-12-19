package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
public class User{
    @Id
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String ADMIN;
    private String STAFF;

    public User(Long id, String name, String email, String password, String aDMIN, String sTAFF) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        ADMIN = aDMIN;
        STAFF = sTAFF;
    }

    public User() {
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getADMIN() {
        return ADMIN;
    }
    public void setADMIN(String aDMIN) {
        ADMIN = aDMIN;
    }
    public String getSTAFF() {
        return STAFF;
    }
    public void setSTAFF(String sTAFF) {
        STAFF = sTAFF;
    }

}