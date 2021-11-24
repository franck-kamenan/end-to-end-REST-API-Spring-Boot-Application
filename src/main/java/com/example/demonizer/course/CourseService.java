package com.example.demonizer.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {

        // return all courses
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                        .forEach(courses::add);
        return courses;
    }

    // Filter by id and take the first id that match
    public Optional<Course> getCourse(String id) {

        return courseRepository.findById(id);
    }

    // Adding a course
    public void addCourse(Course course) {

        courseRepository.save(course);
    }

    // Updating a course
    public void updateCourse(Course course) {

        courseRepository.save(course);
    }

    // Deleting a course
    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }
}

