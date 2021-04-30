package hr.tvz.pripeljas.student;

import hr.tvz.pripeljas.course.Course;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="student")
public class Student implements Serializable
{
    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="last_name")
    private String surname;

    @Column(name="jmbag")
    private String jmbag;

    @Column(name="dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name="numberofects")
    private int numberOfECTS;

    public Student(String name, String surname, String jmbag, LocalDate dateOfBirth, int numberOfECTS)
    {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
    }

    public Student() {}

    public List<Course> getCourses()
    {
        return courses;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String _name)
    {
        name = _name;
    }

    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String _surname)
    {
        surname = _surname;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate _dateOfBirth)
    {
        dateOfBirth = _dateOfBirth;
    }

    public String getJmbag()
    {
        return jmbag;
    }
    public void setJmbag(String _jmbag)
    {
        jmbag = _jmbag;
    }

    public int getNumberOfECTS()
    {
        return numberOfECTS;
    }
    public void setNumberOfECTS(int _numberOfECTS)
    {
        numberOfECTS = _numberOfECTS;
    }
}