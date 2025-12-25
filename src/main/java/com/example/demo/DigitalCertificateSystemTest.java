package com.example.demo;

import com.example.demo.service.DigitalCertificateService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DigitalCertificateSystemTest {

    // Use explicit type here instead of 'var'
    private final DigitalCertificateService certificateService = new DigitalCertificateService();

    @Test
    public void testCreateCertificate() {
        // Inside method, 'var' is allowed
        var certificate = certificateService.createCertificate("RAMYA");
        assertNotNull(certificate);
        assertEquals("RAMYA", certificate.getName());
    }

    @Test
    public void testCertificateValidity() {
        boolean isValid = certificateService.validateCertificate("RAMYA");
        assertTrue(isValid);
    }
}
