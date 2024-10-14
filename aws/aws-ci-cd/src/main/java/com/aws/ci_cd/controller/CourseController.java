package com.aws.ci_cd.controller;

import com.aws.ci_cd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public String addCourse(String courseName) {
        return courseService.addCourse(courseName);
    }

    @GetMapping("/allcourses")
    public List<String> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course")
    public String getCourse(String courseName) {
        return courseService.getCourse(courseName);
    }
}
