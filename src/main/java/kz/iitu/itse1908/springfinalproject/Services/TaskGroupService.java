package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskGroupService {

    final
    TaskGroupRepository taskGroupRepository;

    public TaskGroupService(TaskGroupRepository taskGroupRepository) {
        this.taskGroupRepository = taskGroupRepository;
    }

    public void insert(TaskGroup taskGroup){
        taskGroupRepository.save(taskGroup);
    }

    public void delete(TaskGroup taskGroup){
        taskGroupRepository.delete(taskGroup);
    }

    public Iterable<TaskGroup> getAll(){
        return taskGroupRepository.findAll();
    }

    public void saveAll(Iterable<TaskGroup> taskGroups){
        taskGroupRepository.saveAll(taskGroups);
    }

    public TaskGroup findById(int id) {return  taskGroupRepository.findTaskGroupById(id);}

    public Iterable<TaskGroup> findTaskGroupByGroupid(Group group){return taskGroupRepository.findAllByGroupid(group);}
}
