package com.student.student_management.dto;

import java.util.List;

public class StudentResponse {

    private Long id;
    private String name;
    private String branch;
    private List<String> courses;

    public StudentResponse() {
    }

    public StudentResponse(Long id, String name, String branch, List<String> courses) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
