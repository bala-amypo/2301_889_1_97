package com.example.demo.entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity

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

    @Column(unique = true, nullable = false)
    private String verificationCode;

    @Lob
    private String qrCodeUrl;

    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL)
    private List<VerificationLog> verificationLogs;

        
    public Certificate(Long id, Student student, CertificateTemplate template, LocalDate issuedDate,
            String verificationCode, String qrCodeUrl, List<VerificationLog> verificationLogs) {
        this.id = id;
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.verificationCode = verificationCode;
        this.qrCodeUrl = qrCodeUrl;
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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public List<VerificationLog> getVerificationLogs() {
        return verificationLogs;
    }

    public void setVerificationLogs(List<VerificationLog> verificationLogs) {
        this.verificationLogs = verificationLogs;
    }

}



