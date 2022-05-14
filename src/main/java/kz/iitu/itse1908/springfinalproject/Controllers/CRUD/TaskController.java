package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
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
@RequestMapping(value = "/crud/tasks")
public class TaskController {

    TaskRepository repository;
    @Autowired
    public void TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        List<Task> tasks = (List<Task>) repository.findAll();
        return tasks;
    }

}
