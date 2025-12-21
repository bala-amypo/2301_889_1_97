package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many certificates can belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Many certificates can use one template
    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    private LocalDate issuedDate;

    @Column(length = 5000) // enough to store Base64 QR code
    private String qrCodeUrl;

    @Column(unique = true)
    private String verificationCode; // must start with "VC-"

    public Certificate() {}

    public Certificate(Student student, CertificateTemplate template, LocalDate issuedDate,
                       String qrCodeUrl, String verificationCode) {
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.qrCodeUrl = qrCodeUrl;
        this.verificationCode = verificationCode;
    }

    // Getters and Setters
    public Long getId() { return id; }

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

    // Factory method for easy creation
    public static Certificate create(Student student, CertificateTemplate template,
                                     LocalDate issuedDate, String qrCodeUrl, String verificationCode) {
        return new Certificate(student, template, issuedDate, qrCodeUrl, verificationCode);
    }
}

      @OneToMany(mappedBy = "certificate")
      private List<VerificationLog> verificationLogs = new ArrayList<>();

public List<VerificationLog> getVerificationLogs() {
    return verificationLogs;
}
