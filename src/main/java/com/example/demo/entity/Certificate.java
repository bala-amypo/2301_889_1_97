package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name="certificates",
uniqueConstraints=@UniqueConstraint(columnNames="verificationCode"))

public class Certificate {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne private Student student;
    @ManyToOne private CertificateTemplate template;

    private LocalDate issuedDate;
    private String qrCodeUrl;
    private String verificationCode;
}


