package hr.tvz.pripeljas.student;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MockStudentRepository implements StudentRepository
{
    /*private List<Student> MOCKED_STUDENTS = Arrays.asList(
            new Student("Damir", "Smrtić", "0256423323", LocalDate.now().minusYears(27), 120),
            new Student("Đuro", "Mirić-Vukašinović", "0256423324", LocalDate.now().minusYears(25), 98)
    );*/

    private List<Student> MOCKED_STUDENTS = new ArrayList<Student>();

    public MockStudentRepository()
    {
        MOCKED_STUDENTS.add(new Student("Damir", "Smrtić", "0256423323", LocalDate.now().minusYears(27),  105));
        MOCKED_STUDENTS.add(new Student("Đuro", "Mirić-Vukašinović", "0256423324", LocalDate.now().minusYears(25),  73));
    }

    @Override
    public List<Student> findAll()
    {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJmbag(final String jmbag)
    {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJmbag(), jmbag)).findAny();
    }

    @Override
    public Optional<Student> save(Student student)
    {
        boolean nasao = false;
        for (int i = 0; i < MOCKED_STUDENTS.size(); i++)
        {
            if (MOCKED_STUDENTS.get(i).getJmbag().equals(student.getJmbag()))
            {
                nasao = true;

            }
        }

        if (nasao == false)
        {
            MOCKED_STUDENTS.add(student);
            return Optional.of(student);
        }

        else
        {
            return Optional.empty();
        }

        /*List<Optional<Student>> resultList =
                MOCKED_STUDENTS.stream()
                        .map(Optional::ofNullable)
                        .collect(Collectors.toList());*/

        //return resultList;
    }

    @Override
    public Optional<Student> update(String jmbag, Student mapCommandToStudent)
    {
        return Optional.empty();
    }

    @Override
    public void deleteByJmbag(String jmbag)
    {
        MOCKED_STUDENTS.removeIf(it -> it.getJmbag().equals(jmbag));
    }
}