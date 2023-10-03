package course.api.coursemodel.controller;

import course.api.coursemodel.model.Course;
import course.api.coursemodel.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @GetMapping
    public Map<Integer, Course> courses()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Integer id)
    {
        return courseService.getCourse(id);
    }

    @PostMapping
    public String createCourse(Course course)
    {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id)
    {
        return courseService.deleteCourse(id);
    }

}
