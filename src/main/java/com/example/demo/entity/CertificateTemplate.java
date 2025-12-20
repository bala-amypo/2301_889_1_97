package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name="certificate_templates",
uniqueConstraints=@UniqueConstraint(columnNames="templateName"))

public class CertificateTemplate {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private String backgroundUrl;
    private String fontStyle;
    private String signatureName;
}
