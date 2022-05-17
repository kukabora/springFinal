package kz.iitu.itse1908.springfinalproject.Controllers.CRUD;


import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import kz.iitu.itse1908.springfinalproject.Services.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/crud/testQuestions")
public class TestQuestionsController {

    final
    TestQuestionService testQuestionService;

    public TestQuestionsController(TestQuestionService testQuestionService) {
        this.testQuestionService = testQuestionService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Testquestion> getAllTestsQuestions(){
        List<Testquestion> testquestions = (List<Testquestion>) testQuestionService.getAll();
        return testquestions;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String delete(@RequestBody Testquestion testquestion) {
        testQuestionService.delete(testquestion);
        return "Test question successfully deleted!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody Testquestion testquestion) {
        testQuestionService.insert(testquestion);
        return "Test question succesfully created!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String update(@RequestBody Testquestion testquestion) {
        testQuestionService.insert(testquestion);
        return "Test question succesfully updated!";
    }

}
