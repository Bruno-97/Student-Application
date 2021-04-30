package hr.tvz.pripeljas.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService
{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll()
    {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findBy_Jmbag(final String JMBAG)
    {
        return courseRepository.findByStudents_Jmbag(JMBAG).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToDTO(final Course course)
    {
        return new CourseDTO(course.getName(), course.getNumberOfECTS());
    }
}