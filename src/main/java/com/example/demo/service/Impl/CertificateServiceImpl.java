@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certRepo;
    private final StudentRepository studentRepo;
    private final CertificateTemplateRepository templateRepo;

    public CertificateServiceImpl(
      CertificateRepository certRepo,
      StudentRepository studentRepo,
      CertificateTemplateRepository templateRepo) {
        this.certRepo = certRepo;
        this.studentRepo = studentRepo;
        this.templateRepo = templateRepo;
    }

    public Certificate generateCertificate(Long studentId, Long templateId) {

        Student s = studentRepo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        CertificateTemplate t = templateRepo.findById(templateId)
            .orElseThrow(() -> new RuntimeException("Template not found"));

        String code = "VC-" + UUID.randomUUID();

        return certRepo.save(
            Certificate.builder()
                .student(s)
                .template(t)
                .issuedDate(LocalDate.now())
                .verificationCode(code)
                .qrCodeUrl("data:image/png;base64," + Base64.getEncoder().encodeToString(code.getBytes()))
                .build()
        );
    }

    public Certificate getCertificate(Long id) {
        return certRepo.findById(id)
          .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    public Certificate findByVerificationCode(String code) {
        return certRepo.findByVerificationCode(code)
          .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    public List<Certificate> findByStudentId(Long studentId) {
        Student s = studentRepo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        return certRepo.findByStudent(s);
    }
}


