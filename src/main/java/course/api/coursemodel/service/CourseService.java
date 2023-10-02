package course.api.coursemodel.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService
{
    Map<Integer, String> courses = new HashMap<>();
    Integer INCREMENTER = 0;

    public String getAllCourses()
    {
        return courses.toString();
    }

    public String getCourse(Integer id)
    {
        return courses.get(id);
    }

    public String addCourse(String name)
    {
        if (courses.containsValue(name))
        {
            return "Course already present";
        }
        INCREMENTER += 1;
        courses.put(INCREMENTER, name);
        return "Entry added successfully";
    }

    public String deleteCourse(String name)
    {
        if (courses.containsValue(name))
        {
            return "Course already present";
        }

        return "couse not present";
    }

}
