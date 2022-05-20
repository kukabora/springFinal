package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    Logger logger;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        userService.preDestroy();
    }

    @Test
    void testInsert() {
        User result = userService.insert(new User());
        Assertions.assertEquals(new User(), result);
    }

    @Test
    void testDelete() {
        userService.delete(new User());
    }

    @Test
    void testGetAll() {
        Iterable<User> result = userService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        userService.saveAll(null);
    }

    @Test
    void testFindUserByEmail() {
        when(userRepository.findUserByEmail(anyString())).thenReturn(new User());

        User result = userService.findUserByEmail("email");
        Assertions.assertEquals(new User(), result);
    }

    @Test
    void testFindById() {
        when(userRepository.findUserById(anyInt())).thenReturn(new User());

        User result = userService.findById(0);
        Assertions.assertEquals(new User(), result);
    }
}

