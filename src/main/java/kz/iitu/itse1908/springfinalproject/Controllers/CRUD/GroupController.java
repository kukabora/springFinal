package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;
import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import kz.iitu.itse1908.springfinalproject.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    List<Group> home() {
        return (List<Group>) groupService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Group group) {
        groupService.deleteGroup(group);
        return "Group has been successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Group group) {
        groupService.insertNewGroup(group);
        return "Group succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Group group) {
        groupService.insertNewGroup(group);
        return "Group succesfully updated!";
    }

}
