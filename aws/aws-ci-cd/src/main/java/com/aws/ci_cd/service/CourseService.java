package com.aws.ci_cd.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    List<String> courses = new ArrayList<>();

    public String addCourse(String courseName) {
        courses.add(courseName);
        return "course:" + courseName + " added successfully";
    }

    public List<String> getAllCourses() {
        return courses;
    }

    public String getCourse(String courseName) {
//        Optional<String> any = courses.stream().filter(list -> list.contains(courseName)).findAny();
//        if (any.isPresent()) {
//            return any.get();
//        }
        return courses.stream().filter(list -> list.contains(courseName)).findAny().orElse("course not found");
    }
}
