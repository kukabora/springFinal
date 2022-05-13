package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestQuestionService {

    final
    TestquestionRepository testquestionRepository;

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

}
