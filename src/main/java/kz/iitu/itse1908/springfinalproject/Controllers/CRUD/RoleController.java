package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/roles")
public class RoleController {

    final
    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAllRoles(){
        return (List<Role>) roleService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Role role) {
        roleService.delete(role);
        return "Role successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Role role) {
        roleService.insert(role);
        return "Role succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Role role) {
        roleService.insert(role);
        return "Role succesfully updated!";
    }

}
