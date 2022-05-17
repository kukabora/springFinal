package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.NotificationRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import kz.iitu.itse1908.springfinalproject.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/notifications")
public class NotificationController {

    final
    NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Notification> getAllNotifications(){
        return (List<Notification>) notificationService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Notification notification) {
        notificationService.delete(notification);
        return "Notification successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Notification notification) {
        notificationService.insert(notification);
        return "Notification succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Notification notification) {
        notificationService.insert(notification);
        return "Notification succesfully updated!";
    }

}
