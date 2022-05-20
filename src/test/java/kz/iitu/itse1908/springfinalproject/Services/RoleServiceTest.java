package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Role;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class RoleServiceTest {
    @Mock
    RoleRepository roleRepository;
    @Mock
    Logger logger;
    @InjectMocks
    RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        roleService.preDestroy();
    }

    @Test
    void testInsert() {
        roleService.insert(new Role());
    }

    @Test
    void testDelete() {
        roleService.delete(new Role());
    }

    @Test
    void testGetAll() {
        Iterable<Role> result = roleService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        roleService.saveAll(null);
    }

    @Test
    void testGetRoleByName() {
        when(roleRepository.findRoleByName(anyString())).thenReturn(new Role());

        Role result = roleService.getRoleByName("name");
        Assertions.assertEquals(new Role(), result);
    }

    @Test
    void testGetRoleById() {
        when(roleRepository.findRoleById(anyInt())).thenReturn(new Role());

        Role result = roleService.getRoleById(0);
        Assertions.assertEquals(new Role(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme