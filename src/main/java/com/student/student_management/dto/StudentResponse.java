package com.student.student_management.dto;

import java.util.List;

public class StudentResponse {

    private Long id;
    private String name;
    private String email;
    private String branch;
    private List<String> courses;

    public StudentResponse() {
    }

    public StudentResponse(Long id, String name, String email,
            String branch, List<String> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBranch() {
        return branch;
    }

    public List<String> getCourses() {
        return courses;
    }
}
