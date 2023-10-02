package java.spring.coursemodel.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService
{
    Map<Integer, String> courses = new HashMap<>();

    public String getAllCourses()
    {
        return courses.toString();
    }


}
