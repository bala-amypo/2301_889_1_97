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

    public User(Long id,String name,String email,String ADMIN,String STAFF){
        this.id=id;
        this.name=name;
        this.email=email;
        ADMIN=ADMIN;
        STAFF=STAFF;
    }
    public User(){
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName

}