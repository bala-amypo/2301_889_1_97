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

    public CertificateTemplate(Long id, String templateName, String backgroundUrl, String fontStyle,
            String signatureName) {
        this.id = id;
        this.templateName = templateName;
        this.backgroundUrl = backgroundUrl;
        this.fontStyle = fontStyle;
        this.signatureName = signatureName;
    }
    public CertificateTemplate() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getBackgroundUrl() {
        return backgroundUrl;
    }
    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
    public String getFontStyle() {
        return fontStyle;
    }
    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }
    public String getSignatureName() {
        return signatureName;
    }
    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }
}
