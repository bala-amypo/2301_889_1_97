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

    public User(Long id,String name,String email,String ADMIN,String USER){
        this.id=id;
        this.name=name;
        this.email=email;
        ADMIN=ADMIN;
        USER=USER;
    }
    public User(){
        
    }

}