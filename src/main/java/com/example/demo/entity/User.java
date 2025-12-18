package com.example.demo.entity;

import jakarta.persistence.Column;

public class User{
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

}