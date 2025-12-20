@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student student) {
        if (repo.findByEmail(student.getEmail()).isPresent()
         || repo.findByRollNumber(student.getRollNumber()).isPresent())
            throw new RuntimeException("Student email exists");

        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student findById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
