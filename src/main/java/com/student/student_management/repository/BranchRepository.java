package com.student.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.student_management.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
