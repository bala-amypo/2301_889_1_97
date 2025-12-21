package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        Certificate certificate = certificateService.getCertificate(id);
        return ResponseEntity.ok(certificate);
    }

    @GetMapping("/verify")
    public ResponseEntity<Certificate> getByVerificationCode(@RequestParam String code) {
        Certificate certificate = certificateService.findByVerificationCode(code);
        return ResponseEntity.ok(certificate);
    }
}

