package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(
    name = "certificates",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "verificationCode")
    }
)
public class Certificate {
    private Long id;
    private String name;
    private String verificationCode;
    private List<VerificationLog> verificationLogs = new ArrayList<>();

    public Certificate() {}

    public Certificate(Long id, String name, String verificationCode) {
        this.id = id;
        this.name = name;
        this.verificationCode = verificationCode;
    }

    public static Certificate create(Long id, String name, String code) {
        return new Certificate(id, name, code);
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String code) { this.verificationCode = code; }
    public List<VerificationLog> getVerificationLogs() { return verificationLogs; }
    public void setVerificationLogs(List<VerificationLog> logs) { this.verificationLogs = logs; }
}