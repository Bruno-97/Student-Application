package hr.tvz.pripeljas.student;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcStudentRepository implements StudentRepository
{
    private JdbcTemplate jdbc;
    private SimpleJdbcInsert studentInserter;

    public JdbcStudentRepository(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
        this.studentInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("student")
                .usingGeneratedKeyColumns("student_id");
    }

    @Override
    public List<Student> findAll()
    {
        return jdbc.query("select first_name, last_name, jmbag, dateOfBirth, numberOfECTS from student",
                this::mapRowToStudent);
        //return null;
    }

    @Override
    public Optional<Student> findStudentByJmbag(String jmbag)
    {
        return Optional.ofNullable(jdbc.queryForObject("select first_name, last_name, jmbag, dateOfBirth, numberOfECTS from student where jmbag = ?",
                this::mapRowToStudent, jmbag));
    }

    @Override
    public Optional<Student> save(Student student)
    {
        saveStudentDetails(student);

        return Optional.of(student);
    }

    public long saveStudentDetails(Student student)
    {
        Map<String, Object> values = new HashMap<>();

        values.put("first_name", student.getName());
        values.put("last_name", student.getSurname());
        values.put("jmbag", student.getJmbag());
        values.put("dateOfBirth", student.getDateOfBirth());
        values.put("numberOfECTS", student.getNumberOfECTS());

        return studentInserter.executeAndReturnKey(values).longValue();
    }

    public Optional<Student> update (String JMBAG, Student updatedStudent)
    {
        int proslo = jdbc.update
                ("UPDATE student SET " +
                "first_name = ?," +
                "last_name = ?," +
                "dateOfBirth = ?," +
                "numberOfECTS = ?" +
                "WHERE jmbag = ?",
                updatedStudent.getName(),
                updatedStudent.getSurname(),
                updatedStudent.getDateOfBirth(),
                updatedStudent.getNumberOfECTS(),
                updatedStudent.getJmbag()
                );

        if (proslo > 0)
        {
            return Optional.of(updatedStudent);
        }

        else
        {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByJmbag(String jmbag)
    {
        jdbc.update ("DELETE FROM student_course WHERE student_id IN (SELECT student_id FROM student WHERE jmbag = ?); DELETE FROM student WHERE jmbag = ?;", jmbag, jmbag);
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException
    {
        Student student = new Student();
        student.setName(rs.getString("first_name"));
        student.setSurname(rs.getString("last_name"));
        student.setJmbag(rs.getString("jmbag"));
        student.setDateOfBirth(rs.getTimestamp("dateOfBirth").toLocalDateTime().toLocalDate());
        student.setNumberOfECTS(rs.getInt("numberOfECTS"));

        return student;
    }
}