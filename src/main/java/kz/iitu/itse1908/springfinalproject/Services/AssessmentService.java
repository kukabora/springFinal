package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

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
}
