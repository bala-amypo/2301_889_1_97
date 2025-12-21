package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "certificates",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "verificationCode")
    }
)
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    private LocalDate issuedDate;

    @Column(length = 2000)
    private String qrCodeUrl;

    @Column(nullable = false, unique = true)
    private String verificationCode;

    private List<VerificationLog> verificationLogs;

    public Certificate() {}

    public Certificate(Long id, Student student, CertificateTemplate template,
                       LocalDate issuedDate, String qrCodeUrl, String verificationCode) {
        this.id = id;
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.qrCodeUrl = qrCodeUrl;
        this.verificationCode = verificationCode;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public CertificateTemplate getTemplate() { return template; }
    public void setTemplate(CertificateTemplate template) { this.template = template; }

    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }

    public String getQrCodeUrl() { return qrCodeUrl; }
    public void setQrCodeUrl(String qrCodeUrl) { this.qrCodeUrl = qrCodeUrl; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
     

    

    public List<VerificationLog> getVerificationLogs() {
        return verificationLogs;
    }

    public void setVerificationLogs(List<VerificationLog> logs) {
        this.verificationLogs = logs;
    }

}




