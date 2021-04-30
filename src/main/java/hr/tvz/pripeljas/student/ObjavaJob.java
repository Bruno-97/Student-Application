package hr.tvz.pripeljas.student;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.stream.Collectors;

public class ObjavaJob extends QuartzJobBean
{
    @Autowired
    private StudentService studentService;

    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        List<StudentDTO> listaStudenata = studentService.findAll().stream().collect(Collectors.toList());

        System.out.println("Ovo su trenutno upisani studenti");
        System.out.println("--------------------------------");
        for ( int i = 0; i < listaStudenata.size(); i++)
        {
            System.out.println(listaStudenata.get(i).getJmbag() + " - " + listaStudenata.get(i).getFirstName() + " " + listaStudenata.get(i).getLastName());
        }
        System.out.println("--------------------------------");
    }
}