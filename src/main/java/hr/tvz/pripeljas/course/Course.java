package hr.tvz.pripeljas.course;

import hr.tvz.pripeljas.student.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course")
public class Course implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="numberofects")
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

    public Course() {}

    public List<Student> getStudents()
    {
        return students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getNumberOfECTS()
    {
        return numberOfECTS;
    }

    public void setNumberOfECTS(Integer numberOfECTS)
    {
        this.numberOfECTS = numberOfECTS;
    }
}