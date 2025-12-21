package com.example.demo.repository;

import com.example.demo.entity.VerificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationLogRepo
        extends JpaRepository<VerificationLog, Long> {
}

