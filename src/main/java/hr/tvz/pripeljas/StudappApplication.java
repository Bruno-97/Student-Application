package hr.tvz.pripeljas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(
    scanBasePackages=
    {
            "hr.tvz.pripeljas.config",
            "hr.tvz.pripeljas.course",
            "hr.tvz.pripeljas.security",
            "hr.tvz.pripeljas.security.error",
            "hr.tvz.pripeljas.security.jwt",
            "hr.tvz.pripeljas.student",
            "hr.tvz.pripeljas.user",
            "hr.tvz.pripeljas.web"
     }
)

public class StudappApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StudappApplication.class, args);
    }
}