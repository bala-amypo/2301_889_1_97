package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.demo.entity.CertificateTemplate;

public interface CertificateTemplateRepo extends JpaRepository<CertificateTemplate , Long>{
    Optional<CertificateTemplate> findByTemplateName(String templateName);
    
}