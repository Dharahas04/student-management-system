package com.student.student_management.controller;

import com.student.student_management.dto.StudentResponse;
import com.student.student_management.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentPortalController {

    private final StudentService service;

    public StudentPortalController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public StudentResponse getMyDetails(Authentication authentication) {

        String username = authentication.getName();
        return service.getStudentByEmail(username);
    }
}
