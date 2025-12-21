package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "certificates")
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

    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @Column(name = "qr_code_url", nullable = false)
    private String qrCodeUrl;

    @Column(name = "verification_code", nullable = false, unique = true)
    private String verificationCode;

    
    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VerificationLog> verificationLogs = new ArrayList<>();

    public Certificate() {
    }

    public Certificate(Student student, CertificateTemplate template, LocalDate issuedDate,
                       String qrCodeUrl, String verificationCode) {
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.qrCodeUrl = qrCodeUrl;
        this.verificationCode = verificationCode;
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

    
    public void addVerificationLog(VerificationLog log) {
        verificationLogs.add(log);
        log.setCertificate(this);
    }

    public void removeVerificationLog(VerificationLog log) {
        verificationLogs.remove(log);
        log.setCertificate(null);
    }
}

      