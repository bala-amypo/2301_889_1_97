package com.example.demo.service.impl;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository templateRepository;

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        if (templateRepository.existsByTemplateName(template.getTemplateName())) {
            throw new RuntimeException("Template name exists");
        }
        // Optional: validate URL
        try {
            new URL(template.getBackgroundUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid backgroundUrl");
        }
        return templateRepository.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }
}
