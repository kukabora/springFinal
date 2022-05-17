package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskGroupRepository extends CrudRepository<TaskGroup, Integer> {
    TaskGroup findTaskGroupById(int id);
}