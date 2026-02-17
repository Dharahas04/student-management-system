package com.student.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.entity.*;
import com.student.student_management.repository.*;
import com.student.student_management.dto.EnrollmentRequest;
import java.util.List;

import java.util.stream.Collectors;
import com.student.student_management.dto.EnrollmentResponse;
import com.student.student_management.exception.ResourceNotFoundException;

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
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student not found with id " + request.getStudentId()));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + request.getCourseId()));

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
                        e.getStudent() != null ? e.getStudent().getId() : null,
                        e.getStudent() != null ? e.getStudent().getName() : null,
                        (e.getStudent() != null && e.getStudent().getBranch() != null)
                                ? e.getStudent().getBranch().getBranchName()
                                : null,
                        e.getCourse() != null ? e.getCourse().getCourseName() : null,
                        e.getSemester()))
                .collect(Collectors.toList());
    }

}
