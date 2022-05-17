package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/tasks")
public class TaskController {

    final
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        List<Task> tasks = (List<Task>) taskService.getAll();
        return tasks;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Task task) {
        taskService.delete(task);
        return "Task successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Task task) {
        taskService.insert(task);
        return "Task succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Task task) {
        taskService.insert(task);
        return "Task succesfully updated!";
    }

}
