package kz.iitu.itse1908.springfinalproject.Repositories;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import org.springframework.data.repository.CrudRepository;

public interface UsersgradedetailRepository extends CrudRepository<Usersgradedetail, Integer> {

    Usersgradedetail getUsersgradedetailByUserid(User user);

    boolean existsUsersgradedetailByUserid(User user);

    Usersgradedetail  findUsersgradedetailById(int id);

}