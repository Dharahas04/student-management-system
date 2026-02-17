package com.student.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.student_management.entity.Enrollment;
import com.student.student_management.service.EnrollmentService;
import com.student.student_management.dto.EnrollmentRequest;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @PostMapping
    public Enrollment enrollStudent(@RequestBody EnrollmentRequest request) {
        return service.enrollStudent(request);
    }
}
