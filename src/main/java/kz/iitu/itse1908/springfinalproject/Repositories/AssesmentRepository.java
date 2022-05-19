package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssesmentRepository extends CrudRepository<Assesment, Integer> {
    Assesment findAssesmentById(int id);

    List<Assesment> findAssesmentsByAssessorid(User user);

    boolean existsByAssessoridAndTaskid(User user, Task task);
}