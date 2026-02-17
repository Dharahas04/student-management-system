package com.student.student_management.dto;

public class EnrollmentResponse {

    private Long studentId;
    private String studentName;
    private String branch;
    private String course;
    private String semester;

    public EnrollmentResponse() {
    }

    public EnrollmentResponse(Long studentId, String studentName,
            String branch, String course, String semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.branch = branch;
        this.course = course;
        this.semester = semester;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
