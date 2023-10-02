package course.api.coursemodel.controller;

import course.api.coursemodel.model.Course;
import course.api.coursemodel.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String courses()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Integer id)
    {
        return courseService.getCourse(id);
    }

    @PostMapping
    public String createCourse(Course course)
    {
        return courseService.addCourse(course);
    }

    @DeleteMapping
    public String deleteCourse(Integer id)
    {
        return courseService.deleteCourse(id);
    }

}
