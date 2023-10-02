package course.api.coursemodel.service;

import course.api.coursemodel.model.Course;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService
{
    Map<Integer, Course> courses = new HashMap<>();
    Integer INCREMENTER = 0;

    public String getAllCourses()
    {
        return courses.toString();
    }

    public Course getCourse(Integer id)
    {
        return courses.get(id);
    }

    public String addCourse(Course name)
    {
        if (courses.containsValue(name))
        {
            return "Course already present";
        }
        INCREMENTER += 1;
        courses.put(INCREMENTER, name);
        return "Entry added successfully";
    }

    public String deleteCourse(Integer id)
    {
        if (!courses.containsKey(id))
        {
            return "Course is not present";
        }

        courses.remove(id);
        return "course removed successfully";
    }

}
