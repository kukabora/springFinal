package kz.iitu.itse1908.springfinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Component
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFinalProjectApplication.class, args);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(6 * 1024 * 1024);
        return multipartResolver;
    }

}


