package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/users")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        List<User> users = (List<User>) userService.getAll();
        return users;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody User user) {
        userService.delete(user);
        return "User successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody User user) {
        userService.insert(user);
        return "User succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody User user) {
        userService.insert(user);
        return "User succesfully updated!";
    }

}
