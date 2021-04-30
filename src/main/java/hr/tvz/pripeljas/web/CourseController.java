package hr.tvz.pripeljas.web;

import hr.tvz.pripeljas.course.CourseDTO;
import hr.tvz.pripeljas.course.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("course")
public class CourseController
{
    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses()
    {
        return courseService.findAll();
    }

    @GetMapping(params = "jmbag")
    public List<CourseDTO> getCourseByStudentJMBAG(@RequestParam final String jmbag)
    {
        return courseService.findBy_Jmbag(jmbag);
    }
}