package hr.tvz.pripeljas.student;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig
{
    @Bean
    public JobDetail objavaJobDetail()
    {
        return JobBuilder.newJob(ObjavaJob.class).withIdentity("objavaJob").storeDurably().build();
    }

    @Bean
    public Trigger objavaJobTrigger()
    {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(objavaJobDetail()).withIdentity("objavaTrigger").withSchedule(scheduleBuilder).build();
    }
}
