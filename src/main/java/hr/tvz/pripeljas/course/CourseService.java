package hr.tvz.pripeljas.course;

import java.util.List;

public interface CourseService
{
    List<CourseDTO> findAll();

    List<CourseDTO> findBy_Jmbag(String jmbag);
}
