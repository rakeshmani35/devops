package com.javatechie.aws.cicd.service;

import com.javatechie.aws.cicd.dto.Course;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    Map<Integer, Course> map = new HashMap<>();

    public void addCourse(Course course) {
        map.put(course.getId(), course);
    }

    public List<Course> getAllCources() {
        return map.values().stream().toList();
    }

    public Optional<Course> getCourseById(int id) {
        return Optional.ofNullable(map.get(id));
    }

    public boolean updateCourse(int id, Course newCourse) {
        Optional<Course> optionalCourse = Optional.ofNullable(map.get(id));
        if (optionalCourse.isPresent()) {
            map.put(id, newCourse);
            return true;
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        Optional<Course> optionalCourse = Optional.ofNullable(map.get(id));
        if (optionalCourse.isPresent()) {
            map.remove(id);
            return true;
        }
        return false;
    }
}
