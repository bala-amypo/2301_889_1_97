package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping
    public ResponseEntity<CertificateTemplate> addTemplate(@RequestBody CertificateTemplate template) {
        CertificateTemplate saved = templateService.addTemplate(template);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<CertificateTemplate>> getAllTemplates() {
        List<CertificateTemplate> templates = templateService.getAllTemplates();
        return ResponseEntity.ok(templates);
    }
}
