public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student findById(Long id);
}
