package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskGroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void insert(Task task){
        taskRepository.save(task);
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }

    public Iterable<Task> getAll(){
        return taskRepository.findAll();
    }

    public void saveAll(Iterable<Task> tasks){
        taskRepository.saveAll(tasks);
    }

}