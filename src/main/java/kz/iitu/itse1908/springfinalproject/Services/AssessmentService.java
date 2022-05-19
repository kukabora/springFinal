package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.AOPConfiguration.Logging;
import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AssessmentService {

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

    final
    AssesmentRepository assesmentRepository;

    public AssessmentService(AssesmentRepository assesmentRepository) {
        this.assesmentRepository = assesmentRepository;
    }

    public void insertNewAssesment(Assesment assessment){
        assesmentRepository.save(assessment);
    }

    public void deleteAssessment(Assesment assesment){
        assesmentRepository.delete(assesment);
    }

    public Iterable<Assesment> getAll(){
        return assesmentRepository.findAll();
    }

    public void saveAll(Iterable<Assesment> assesments){
        assesmentRepository.saveAll(assesments);
    }

    public Assesment findById(int id) {return assesmentRepository.findAssesmentById(id);}


    public Iterable<Assesment> findAllByAssessorId(User user){return assesmentRepository.findAssesmentsByAssessorid(user);}

    public boolean checkIfAlreadyAssessed(User user, Task task){ return assesmentRepository.existsByAssessoridAndTaskid(user, task);}


}
