package com.example.demonizer.course;

import java.util.List;
import java.util.Optional;

import com.example.demonizer.topic.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/courses/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {

        return courseService.getAllCourses(id);
    }

    // Getting a single resource
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {

        return courseService.getCourse(id);
    }

    // Creating a new resource with POST
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {

        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }
    
    // Implementing Update with PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    // Implementing Delete with DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {

        courseService.deleteCourse(id);
    }
}

