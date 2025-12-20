package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

import com.example.demo.entity.Certificate;

public interface CertificateRepo extends JpaRepository<Certificate , Long>{
    Optional<Certificate> findByVerificationCode(String code);
    List<Certificate> findByStudent(Student student);
    
}