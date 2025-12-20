package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    // POST /certificates/generate/{studentId}/{templateId}
    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(
            @PathVariable Long studentId,
            @PathVariable Long templateId) {

        return service.generateCertificate(studentId, templateId);
    }

    // GET /certificates/{certificateId}
    @GetMapping("/{certificateId}")
    public Certificate getCertificate(
            @PathVariable Long certificateId) {

        return service.getCertificate(certificateId);
    }

    // GET /certificates/verify/code/{verificationCode}
    @GetMapping("/verify/code/{verificationCode}")
    public Certificate verifyByCode(
            @PathVariable String verificationCode) {

        return service.findByVerificationCode(verificationCode);
    }
}
