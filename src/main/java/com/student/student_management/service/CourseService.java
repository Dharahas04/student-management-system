package com.student.student_management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.student_management.entity.Course;
import com.student.student_management.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course saveCourse(Course course) {
        return repository.save(course);
    }
}
