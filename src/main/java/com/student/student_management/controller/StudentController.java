package com.student.student_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.student.student_management.entity.Student;
import com.student.student_management.service.StudentService;
import com.student.student_management.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import com.student.student_management.dto.StudentResponse;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    // @GetMapping("/{id}")
    // public Student getStudent(@PathVariable Long id) {
    // return service.getStudentById(id);
    // }
    @GetMapping("/{id}")
    public StudentResponse getStudentWithCourses(@PathVariable Long id) {
        return service.getStudentWithCourses(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully!";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existing = service.getStudentById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());

        return service.saveStudent(existing);
    }

}
