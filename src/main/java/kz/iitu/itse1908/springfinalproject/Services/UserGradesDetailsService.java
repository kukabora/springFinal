package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserGradesDetailsService {

    final
    UsersgradedetailRepository usersgradedetailRepository;

    final
    UserService userService;

    public UserGradesDetailsService(UsersgradedetailRepository usersgradedetailRepository, UserService userService) {
        this.usersgradedetailRepository = usersgradedetailRepository;
        this.userService = userService;
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

    public Usersgradedetail getUserGradesByUserId(User user){
        return usersgradedetailRepository.getUsersgradedetailByUserid(user);
    }

    public boolean checkIfDetailsExistsByUserId(int userId){
        return usersgradedetailRepository.existsUsersgradedetailByUserid(null);
    }

//    @Scheduled(cron = "* * * ? * *")
//    public void checkIfAllUsersHaveGradesDetails(){
//        Iterable<User> users = userService.getAll();
//        AtomicInteger k = new AtomicInteger(0);
//        users.forEach(user -> {
//            int id = user.getId();
//            if (!usersgradedetailRepository.existsUsersgradedetailByUserid(user)){
//                k.getAndIncrement();
//                Usersgradedetail currentUsersGrades = new Usersgradedetail();
//                currentUsersGrades.setGpa(0.0);
//                currentUsersGrades.setGradedassessments(0);
//                currentUsersGrades.setReadyassessments(0);
//                currentUsersGrades.setUserid(user);
//                usersgradedetailRepository.save(currentUsersGrades);
//            }
//        });
//        if (k.get() != 0){
//            System.out.println("FOUND " + k + " USERS WITHOUT USERSGRADEDETAILS!");
//            System.out.println("Fixing...");
//        }
//    }

//    UNCOMMENT FOR DEMONSTRATION

}
