package com.student.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.student.student_management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
