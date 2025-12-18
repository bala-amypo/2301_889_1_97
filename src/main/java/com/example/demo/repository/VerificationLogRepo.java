package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FraqudCheckResult;

public interface FraudCheckResultRepo extends JpaRepository<FraudCheckResult , Long>{
    
}