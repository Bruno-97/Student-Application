package hr.tvz.pripeljas.student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentByJmbag(String jmbag);

    Optional<StudentDTO> save(StudentCommand command);

    Optional<StudentDTO> update(String jmbag, StudentCommand updatedStudentCommand);

    void deleteByJmbag(String jmbag);
}