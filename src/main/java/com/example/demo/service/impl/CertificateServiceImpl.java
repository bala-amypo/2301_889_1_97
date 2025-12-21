package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.entity.Student;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CertificateTemplateRepository templateRepository;

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        CertificateTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        String verificationCode = "VC-" + UUID.randomUUID();

        String qrCodeDataUrl = generateQRCodeDataUrl(verificationCode);

        Certificate certificate = Certificate.builder()
                .student(student)
                .template(template)
                .issuedDate(LocalDate.now())
                .verificationCode(verificationCode)
                .qrCodeUrl(qrCodeDataUrl)
                .build();

        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificate(Long certificateId) {
        return certificateRepository.findById(certificateId)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    @Override
    public Certificate findByVerificationCode(String code) {
        return certificateRepository.findByVerificationCode(code)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    @Override
    public List<Certificate> findByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return certificateRepository.findByStudent(student);
    }

    private String generateQRCodeDataUrl(String text) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            var bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
            return "data:image/png;base64," + base64;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate QR code");
        }
    }
}


