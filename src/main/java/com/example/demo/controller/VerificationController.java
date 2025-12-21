package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verification")
public class VerificationController {

    private final VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/verify")
    public ResponseEntity<VerificationLog> verifyCertificate(@RequestParam String code,
                                                             @RequestParam String clientIp) {
        VerificationLog log = verificationService.verifyCertificate(code, clientIp);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/logs/{certificateId}")
    public ResponseEntity<List<VerificationLog>> getLogs(@PathVariable Long certificateId) {
        List<VerificationLog> logs = verificationService.getLogsByCertificate(certificateId);
        return ResponseEntity.ok(logs);
    }
}


