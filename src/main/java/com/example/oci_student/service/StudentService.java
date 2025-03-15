package com.example.oci_student.service;
import com.example.oci_student.model.Student;
import com.example.oci_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    public Optional<Student> getStudentByStudentId(String studentId) {
        Student exampleStudent = new Student();
        exampleStudent.setStudentId(studentId);
        Example<Student> example = Example.of(exampleStudent);
        return studentRepository.findOne(example);
    }
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setEmail(studentDetails.getEmail());
            student.setStudentId(studentDetails.getStudentId());
            return studentRepository.save(student);
        }).orElse(null);
    }
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
        studentRepository.deleteById(id);
        return true;
        }
        return false;
    }
}
