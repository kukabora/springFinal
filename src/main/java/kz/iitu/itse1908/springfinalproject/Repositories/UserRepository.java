package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}