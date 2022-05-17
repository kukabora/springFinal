package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Repositories.TestRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

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

}
