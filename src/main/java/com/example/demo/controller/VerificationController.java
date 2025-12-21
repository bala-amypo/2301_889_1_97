package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    // POST /verify/{verificationCode}
    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(@PathVariable String verificationCode,
                                             HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        return verificationService.verify(verificationCode, ipAddress);
    }

    // GET /verify/logs/{certificateId}
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getVerificationLogs(@PathVariable Long certificateId) {
        return verificationService.getLogs(certificateId);
    }
}


