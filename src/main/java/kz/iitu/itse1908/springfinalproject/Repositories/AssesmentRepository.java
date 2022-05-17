package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import org.springframework.data.repository.CrudRepository;

public interface AssesmentRepository extends CrudRepository<Assesment, Integer> {
    Assesment findAssesmentById(int id);
}