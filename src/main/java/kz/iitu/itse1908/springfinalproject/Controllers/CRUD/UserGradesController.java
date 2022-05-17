package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import kz.iitu.itse1908.springfinalproject.Services.UserGradesDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/usersGrades")
public class UserGradesController {

    final
    UserGradesDetailsService userGradesDetailsService;

    public UserGradesController(UserGradesDetailsService userGradesDetailsService) {
        this.userGradesDetailsService = userGradesDetailsService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usersgradedetail> getAllUsersGradeDetails(){
        List<Usersgradedetail> usersgradedetails = (List<Usersgradedetail>) userGradesDetailsService.getAll();
        return usersgradedetails;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Usersgradedetail usersgradedetail) {
        userGradesDetailsService.delete(usersgradedetail);
        return "Users grade details successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Usersgradedetail usersgradedetail) {
        userGradesDetailsService.insert(usersgradedetail);
        return "Users grade details  succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Usersgradedetail usersgradedetail) {
        userGradesDetailsService.insert(usersgradedetail);
        return "Users grade details  succesfully updated!";
    }

}
