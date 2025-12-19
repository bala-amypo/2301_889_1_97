public interface VerificationService {
    VerificationLog verifyCertificate(String verificationCode, String clientIp);
    List<VerificationLog> getLogsByCertificate(Long certificateId);
}
