package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.RequestsLogRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    final
    RoleRepository roleRepository;

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
