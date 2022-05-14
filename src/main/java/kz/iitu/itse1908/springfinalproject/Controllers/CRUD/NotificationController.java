package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.NotificationRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/notifications")
public class NotificationController {

    NotificationRepository repository;

    @Autowired
    public void NotificationController(NotificationRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Notification> getAllNotifications(){
        return (List<Notification>) repository.findAll();
    }

}
