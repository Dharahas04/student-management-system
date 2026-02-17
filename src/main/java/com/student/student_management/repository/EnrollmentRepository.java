package com.student.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.student_management.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
