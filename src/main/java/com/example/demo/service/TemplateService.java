public interface TemplateService {
    CertificateTemplate addTemplate(CertificateTemplate template);
    List<CertificateTemplate> getAllTemplates();
    CertificateTemplate findById(Long id);
}
