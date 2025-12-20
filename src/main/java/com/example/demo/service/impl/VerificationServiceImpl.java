@Service
public class VerificationServiceImpl implements VerificationService {

    private final CertificateRepository certRepo;
    private final VerificationLogRepository logRepo;

    public VerificationServiceImpl(CertificateRepository c, VerificationLogRepository l) {
        this.certRepo = c;
        this.logRepo = l;
    }

    public VerificationLog verifyCertificate(String code, String ip) {
        Optional<Certificate> cert = certRepo.findByVerificationCode(code);

        VerificationLog log = VerificationLog.builder()
            .certificate(cert.orElse(null))
            .verifiedAt(LocalDateTime.now())
            .status(cert.isPresent() ? "SUCCESS" : "FAILED")
            .ipAddress(ip)
            .build();

        return logRepo.save(log);
    }

    public List<VerificationLog> getLogsByCertificate(Long id) {
        Certificate c = certRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Certificate not found"));
        return logRepo.findAll()
            .stream().filter(l -> c.equals(l.getCertificate())).toList();
    }
}

