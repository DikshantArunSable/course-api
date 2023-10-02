package java.spring.coursemodel.controller;

import org.springframework.web.bind.annotation.*;

import java.spring.coursemodel.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController
{

    private CourseService courseService;

    @GetMapping
    public String courses()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public String getCourse(Integer id)
    {
        return "abc";
    }

    @PostMapping
    public String createCourse(String course)
    {
        return "course added successfully";
    }

    @DeleteMapping
    public String deleteCourse(String courseNumber)
    {
        return "course added successfully";
    }

}
