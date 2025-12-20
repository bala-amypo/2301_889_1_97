package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student , Long>{
    Optional<Student> findByEmail(String email);
    Optional<Student> findByRollNumber(String rollNumber);
    
}