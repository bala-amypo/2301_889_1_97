package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService service;

    public TemplateController(TemplateService service) {
        this.service = service;
    }

    // POST /templates
    @PostMapping
    public CertificateTemplate addTemplate(
            @RequestBody CertificateTemplate template) {
        return service.addTemplate(template);
    }

    // GET /templates
    @GetMapping
    public List<CertificateTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }
}
