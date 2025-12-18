package com.example.demo.entity;

public class CertificateTemplate{
    @Id
    private Long id;
    @Column(unique=true)
    private String templateName;
    private String backgroundUrl;
    private String fontStyle;
    private String signatureName;
}