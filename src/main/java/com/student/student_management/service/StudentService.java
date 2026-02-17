package com.student.student_management.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.student_management.entity.Student;
import com.student.student_management.repository.StudentRepository;
import java.util.stream.Collectors;
import com.student.student_management.dto.StudentResponse;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public StudentResponse getStudentWithCourses(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<String> courseNames = new ArrayList<>();

        if (student.getEnrollments() != null) {
            courseNames = student.getEnrollments()
                    .stream()
                    .map(e -> e.getCourse().getCourseName())
                    .collect(Collectors.toList());
        }

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getBranch() != null ? student.getBranch().getBranchName() : null,
                courseNames);
    }

}
