package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskGroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    final
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

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

    public Iterable<Task> findAllById(Iterable<Integer> ids){
        return taskRepository.findAllById(ids);
    }

    public Task findById(int id){return taskRepository.findTaskById(id);}

    public Task findByTestId(Test test){return taskRepository.findByTestid(test);}

}
