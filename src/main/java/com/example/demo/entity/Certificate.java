package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
        name = "certificates",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "verificationCode")
        }
)

@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private CertificateTemplate template;

    private LocalDate issuedDate;

    @Column(length = 5000)
    private String qrCodeUrl;

    @Column(nullable = false, unique = true)
    private String verificationCode;

    @OneToMany(mappedBy = "certificate")
    private List<VerificationLog> verificationLogs;
    
    public Certificate(Long id, Student student, CertificateTemplate template, LocalDate issuedDate, String qrCodeUrl,
            String verificationCode, List<VerificationLog> verificationLogs) {
        this.id = id;
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.qrCodeUrl = qrCodeUrl;
        this.verificationCode = verificationCode;
        this.verificationLogs = verificationLogs;
    }

    public Certificate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CertificateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CertificateTemplate template) {
        this.template = template;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public List<VerificationLog> getVerificationLogs() {
        return verificationLogs;
    }

    public void setVerificationLogs(List<VerificationLog> verificationLogs) {
        this.verificationLogs = verificationLogs;
    }



}



