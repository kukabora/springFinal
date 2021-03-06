package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.Test;
import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestquestionRepository extends CrudRepository<Testquestion, Integer> {
    Testquestion findTestquestionById(int id);

    Iterable<Testquestion> getAllByTestid(Test test);

}