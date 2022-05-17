package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(User user){
        userRepository.save(user);
        return user;
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public void saveAll(Iterable<User> users){
        userRepository.saveAll(users);
    }

    public User findUserByEmail(String email) {return  userRepository.findUserByEmail(email);}

    public User findById(int id) {return userRepository.findUserById(id);}
}
