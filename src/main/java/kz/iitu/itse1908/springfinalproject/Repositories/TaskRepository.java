package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    Task findTaskById(int id);

    Iterable<Task> findAllById(Iterable<Integer> ids);

    Task findByTestid(Test test);

    boolean existsById(int id);
}