package com.student.student_management.controller;

import com.student.student_management.dto.StudentResponse;
import com.student.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff/students")
public class StaffStudentController {

    private final StudentService service;

    public StaffStudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentDetails(@PathVariable Long id) {
        return service.getStudentWithCourses(id);
    }
}
