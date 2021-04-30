package hr.tvz.pripeljas.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class StudentCommand
{
    @JsonProperty("firstName")
    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @JsonProperty("jmbag")
    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;

    @JsonProperty("dateOfBirth")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") //1970-01-01T00:00:01.990Z
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @JsonProperty("numberOfECTS")
    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private Integer numberOfECTS;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getJmbag()
    {
        return jmbag;
    }

    public void setJmbag(String jmbag)
    {
        this.jmbag = jmbag;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
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
