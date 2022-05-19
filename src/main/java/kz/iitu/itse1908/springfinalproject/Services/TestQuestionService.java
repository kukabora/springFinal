package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service
public class TestQuestionService {

    final
    TestquestionRepository testquestionRepository;

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

    public TestQuestionService(TestquestionRepository testquestionRepository) {
        this.testquestionRepository = testquestionRepository;
    }

    public void insert(Testquestion testquestion){
        testquestionRepository.save(testquestion);
    }

    public void delete(Testquestion testquestion){
        testquestionRepository.delete(testquestion);
    }

    public Iterable<Testquestion> getAll(){
        return testquestionRepository.findAll();
    }

    public void saveAll(Iterable<Testquestion> testquestions){
        testquestionRepository.saveAll(testquestions);
    }

    public Testquestion findById(int id ){return testquestionRepository.findTestquestionById(id);}

    public Iterable<Testquestion> findAllByTestId(Test test){return testquestionRepository.getAllByTestid(test);}

}
