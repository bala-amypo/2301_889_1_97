package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verify")
@RequiredArgsConstructor
public class VerificationController {

    private final VerificationService verificationService;

    @PostMapping("/{verificationCode}")
    public ResponseEntity<VerificationLog> verifyCertificate(
            @PathVariable String verificationCode,
            HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        VerificationLog log = verificationService.verifyCertificate(verificationCode, clientIp);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/logs/{certificateId}")
    public ResponseEntity<List<VerificationLog>> getLogsByCertificate(@PathVariable Long certificateId) {
        List<VerificationLog> logs = verificationService.getLogsByCertificate(certificateId);
        return ResponseEntity.ok(logs);
    }
}
