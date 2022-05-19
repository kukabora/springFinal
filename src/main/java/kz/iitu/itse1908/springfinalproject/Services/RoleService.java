package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.RequestsLogRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class RoleService {

    final
    RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(AssessmentService.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("Service " + this.getClass().getSimpleName() + " is destroyed");
    }

    @PostConstruct
    private void postConstruct() {
        logger.info("Service " + this.getClass().getSimpleName() + " is initialized");
    }

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void insert(Role role){
        roleRepository.save(role);
    }

    public void delete(Role role){
        roleRepository.delete(role);
    }

    public Iterable<Role> getAll(){
        return roleRepository.findAll();
    }

    public void saveAll(Iterable<Role> roles){
        roleRepository.saveAll(roles);
    }

    public Role getRoleByName(String name) {return roleRepository.findRoleByName(name);}

    public Role getRoleById(int id) {return roleRepository.findRoleById(id);}

}
