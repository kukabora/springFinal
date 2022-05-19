package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Repositories.TestRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TestService {

    final
    TestRepository testRepository;

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void insert(Test test){
        testRepository.save(test);
    }

    public void delete(Test test){
        testRepository.delete(test);
    }

    public Iterable<Test> getAll(){
        return testRepository.findAll();
    }

    public void saveAll(Iterable<Test> tests){
        testRepository.saveAll(tests);
    }

    public Test findById(int id) {return testRepository.findTestById(id);}

    public boolean existsById(int id){return testRepository.existsById(id);}

}
