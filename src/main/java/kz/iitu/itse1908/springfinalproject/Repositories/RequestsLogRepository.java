package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import org.springframework.data.repository.CrudRepository;

public interface RequestsLogRepository extends CrudRepository<RequestsLog, Integer> {
}