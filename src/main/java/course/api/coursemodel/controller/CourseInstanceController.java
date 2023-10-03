package course.api.coursemodel.controller;

import course.api.coursemodel.model.CourseInstance;
import course.api.coursemodel.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController
{

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public ResponseEntity<?> courses(@RequestParam(name = "year", required = false) Integer year,
                                     @RequestParam(name = "semester", required = false) Integer semester,
                                     @RequestParam(name = "id", required = false) Integer id)
    {
        return courseService.getCourseInstance(year, semester, id);
    }

    @PostMapping
    public String createCourse(CourseInstance courseInstance)
    {
        return courseService.createCourseInstance(courseInstance);
    }

    @DeleteMapping()
    public String deleteCoursecourses(@RequestParam(name = "year", required = false) Integer year,
                                      @RequestParam(name = "semester", required = false) Integer semester,
                                      @RequestParam(name = "id", required = false) Integer id)
    {
        return courseService.deleteCourseInstance(year, semester, id);
    }

}
