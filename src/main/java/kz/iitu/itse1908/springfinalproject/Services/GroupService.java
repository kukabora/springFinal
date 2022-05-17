package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

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
}
