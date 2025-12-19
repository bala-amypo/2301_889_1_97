public interface CertificateService {
    Certificate generateCertificate(Long studentId, Long templateId);
    Certificate getCertificate(Long certificateId);
    Certificate findByVerificationCode(String code);
    List<Certificate> findByStudentId(Long studentId);
}
