package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGradesDetailsService {

    final
    UsersgradedetailRepository usersgradedetailRepository;

    public UserGradesDetailsService(UsersgradedetailRepository usersgradedetailRepository) {
        this.usersgradedetailRepository = usersgradedetailRepository;
    }

    public void insert(Usersgradedetail usersgradedetail){
        usersgradedetailRepository.save(usersgradedetail);
    }

    public void delete(Usersgradedetail usersgradedetail){
        usersgradedetailRepository.delete(usersgradedetail);
    }

    public Iterable<Usersgradedetail> getAll(){
        return usersgradedetailRepository.findAll();
    }

    public void saveAll(Iterable<Usersgradedetail> usersgradedetails){
        usersgradedetailRepository.saveAll(usersgradedetails);
    }

}
