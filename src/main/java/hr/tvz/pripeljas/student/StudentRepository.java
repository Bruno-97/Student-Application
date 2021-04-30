package hr.tvz.pripeljas.student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository
{
    List<Student> findAll();

    Optional<Student> findStudentByJmbag(String jmbag);

    //List<Optional<Student>>
    Optional<Student> save(Student student);

    Optional<Student> update(String jmbag, Student mapCommandToStudent);

    void deleteByJmbag(String jmbag);
}
