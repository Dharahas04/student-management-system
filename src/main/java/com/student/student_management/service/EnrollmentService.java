package com.student.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.entity.*;
import com.student.student_management.repository.*;
import com.student.student_management.dto.EnrollmentRequest;
import java.util.List;

import java.util.stream.Collectors;
import com.student.student_management.dto.EnrollmentResponse;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollStudent(EnrollmentRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setSemester(request.getSemester());

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<EnrollmentResponse> getAllEnrollmentResponses() {
        return enrollmentRepository.findAll().stream()
                .map(e -> new EnrollmentResponse(
                        e.getStudent().getId(),
                        e.getStudent().getName(),
                        e.getStudent().getBranch().getBranchName(),
                        e.getCourse().getCourseName(),
                        e.getSemester()))
                .collect(Collectors.toList());
    }

}
