package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/usersGrades")
public class UserGradesController {

    UsersgradedetailRepository repository;
    @Autowired
    public void UserGradesController(UsersgradedetailRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usersgradedetail> getAllUsersGradeDetails(){
        List<Usersgradedetail> usersgradedetails = (List<Usersgradedetail>) repository.findAll();
        return usersgradedetails;
    }

}
