package course.api.coursemodel.service;

import course.api.coursemodel.model.Course;
import course.api.coursemodel.model.CourseInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService
{
    Map<Integer, Course> courses = new HashMap<>();
    List<CourseInstance> coursesInstance = new ArrayList<>();
    Integer INCREMENTER = 0;

    public Map<Integer, Course> getAllCourses()
    {
        return courses;
    }

    public ResponseEntity<?> getCourse(Integer id)
    {
        if (courses.get(id) != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(courses.get(id));
        }
        return ResponseEntity.status(HttpStatus.OK).body("No course present for this id");
    }

    public String addCourse(Course course)
    {
        for (Course cour : courses.values())
            if (cour.hashCode() == course.hashCode())
            {
                return "Course already present";
            }
        INCREMENTER += 1;
        courses.put(INCREMENTER, course);
        return "Entry added successfully";
    }

    public String deleteCourse(Integer id)
    {
        if (!courses.containsKey(id))
        {
            return "No course present for this id";
        }

        courses.remove(id);
        return "course removed successfully";
    }

    public String createCourseInstance(CourseInstance courseInstance)
    {
        for (CourseInstance courseInst : this.coursesInstance)
        {
            if (courseInst.hashCode() == courseInstance.hashCode())

            {
                return "course instance already present";
            }
        }
        if (courses.get(courseInstance.id()) == null)
        {
            return "no course present for this id";
        }
        this.coursesInstance.add(courseInstance);
        return "Course instance created";
    }

    public ResponseEntity<?> getCourseInstance(Integer year, Integer semester, Integer id)
    {
        List<CourseInstance> matched = new ArrayList<>();
        for (CourseInstance courseInst : coursesInstance)
        {
            if ((year == null || courseInst.year() == year) && (semester == null || courseInst.semester() == semester) && (id == null || courseInst.id() == id))
            {
                matched.add(courseInst);
            }
        }
        if (matched.size() > 0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(matched);
        }
        return ResponseEntity.status(HttpStatus.OK).body("No courseInstance created till now ");
    }

    public String deleteCourseInstance(Integer year, Integer semester, Integer id)
    {
        CourseInstance courseInstance = new CourseInstance(id, year, semester);
        for (CourseInstance courseInst : coursesInstance)
        {
            if (courseInst.hashCode() == courseInstance.hashCode())
            {
                coursesInstance.remove(courseInst);
                return "removed course instance";
            }
        }
        return "no course with such instance";
    }


}
