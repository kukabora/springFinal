package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.TestRepository;
import kz.iitu.itse1908.springfinalproject.Services.TestService;
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
@RequestMapping(value = "/crud/tests")
public class TestController {

    final
    TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Test> getAllTests(){
        List<Test> tests = (List<Test>) testService.getAll();
        return tests;
    }

}
