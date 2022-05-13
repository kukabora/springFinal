package kz.iitu.itse1908.springfinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@Component
@EntityScan("kz.iitu.itse1908.springfinalproject.*")
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableScheduling
public class SpringFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFinalProjectApplication.class, args);
    }

}
