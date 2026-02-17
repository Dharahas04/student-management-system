package com.student.student_management.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchName;

    @OneToMany(mappedBy = "branch")
    private List<Student> students;

    // getters and setters
}
