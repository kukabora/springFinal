package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class GroupService {

    final
    GroupRepository groupRepository;

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void insertNewGroup(Group group){
        groupRepository.save(group);
    }

    public void deleteGroup(Group group){
        groupRepository.delete(group);
    }

    public Iterable<Group> getAll(){
        return groupRepository.findAll();
    }

    public void saveAll(Iterable<Group> groups){
        groupRepository.saveAll(groups);
    }

    public Group findGroupByName(String name) { return groupRepository.findGroupByName(name); }

    public Group findGroupById(int id) { return groupRepository.findGroupById(id); }

}
