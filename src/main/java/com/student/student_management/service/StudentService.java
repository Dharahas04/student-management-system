package com.student.student_management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.dto.StudentResponse;
import com.student.student_management.entity.Student;
import com.student.student_management.exception.ResourceNotFoundException;
import com.student.student_management.repository.StudentRepository;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.Objects;

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

    @Transactional(readOnly = true)
    public StudentResponse getStudentWithCourses(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        String branchName = student.getBranch() != null ? student.getBranch().getBranchName() : null;

        List<String> courseNames = student.getEnrollments() == null
                ? Collections.emptyList()
                : student.getEnrollments().stream()
                        .map(enrollment -> enrollment.getCourse())
                        .filter(Objects::nonNull)
                        .map(course -> course.getCourseName())
                        .collect(Collectors.toList());

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                branchName,
                courseNames);
    }

    public StudentResponse getStudentByEmail(String email) {
        Student student = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return getStudentWithCourses(student.getId());
    }

}
