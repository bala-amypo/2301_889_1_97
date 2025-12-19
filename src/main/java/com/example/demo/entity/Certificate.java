package com.example.demo.entity;

public class Certificate{
    @Id
    private Long id;
    private LocalDate issuedDate;
    private String qrCodeUrl;
    @Column(unique=true)
    private String verificationCode;
}

