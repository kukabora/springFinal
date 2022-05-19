package kz.iitu.itse1908.springfinalproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@EnableAsync
public class SchedulingConfiguration {

    @Async
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void scheduleFixedDelay(){
        System.out.println("--------------------");
        System.out.println("THIS MESSAGE IS DISPLAYED EVERY 10 MINUTES");
        System.out.println("THIS METHOD WILL NOT BE INVOKED UNTIL PREVIOUS CALL WILL BE FULLY EXECUTED.");
    }

    @Async
    @Scheduled(fixedRate = 1000 * 60 * 20)
    public void scheduleFixedRate(){
        System.out.println("--------------------");
        System.out.println("THIS MESSAGE IS DISPLAYED EVERY 20 MINUTES");
        System.out.println("THIS METHOD WILL BE INVOKED EVEN IF IT'S PREVIOUS EXECUTION HAS NOT BEEN FINISHED BECAUSE OF FIXEDRATE ATRIBUTE.");
    }

    @Async
    @Scheduled(fixedDelay = 1000 * 30 * 10,initialDelay = 1000 * 5)
    public void initialDelay(){
        System.out.println("--------------------");
        System.out.println("THIS MESSAGE IS DISPLAYED AFTER 5 SECONDS FROM APPLICATION START AND THEN EVERY 30 MINUTES.");
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(3);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }
}