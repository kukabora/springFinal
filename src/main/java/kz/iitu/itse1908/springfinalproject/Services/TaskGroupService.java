package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service
public class TaskGroupService {

    final
    TaskGroupRepository taskGroupRepository;

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

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
