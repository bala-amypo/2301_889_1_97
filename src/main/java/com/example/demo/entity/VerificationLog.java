package com.example.demo.entity;

public class VerificationLog {
    @Id
    private Long id;
    private LocalDateTime verifiedAt;
    private String SUCCESS;
    private String FAILED;
    private String ipAddress;
    
}