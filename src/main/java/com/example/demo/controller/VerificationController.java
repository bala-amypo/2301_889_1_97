package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService service;

    public VerificationController(VerificationService service) {
        this.service = service;
    }

    // POST /verify/{verificationCode}
    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(
            @PathVariable String verificationCode,
            HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        return service.verifyCertificate(verificationCode, ip);
    }

    // GET /verify/logs/{certificateId}
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogs(
            @PathVariable Long certificateId) {

        return service.getLogsByCertificate(certificateId);
    }
}
