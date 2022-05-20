package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Repositories.UsersgradedetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class UserGradesDetailsServiceTest {
    @Mock
    UsersgradedetailRepository usersgradedetailRepository;
    @Mock
    Logger logger;
    @Mock
    UserService userService;
    @InjectMocks
    UserGradesDetailsService userGradesDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        userGradesDetailsService.preDestroy();
    }

    @Test
    void testInsert() {
        userGradesDetailsService.insert(new Usersgradedetail());
    }

    @Test
    void testDelete() {
        userGradesDetailsService.delete(new Usersgradedetail());
    }

    @Test
    void testGetAll() {
        Iterable<Usersgradedetail> result = userGradesDetailsService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        userGradesDetailsService.saveAll(null);
    }

    @Test
    void testGetUserGradesByUserId() {
        when(usersgradedetailRepository.getUsersgradedetailByUserid(any())).thenReturn(new Usersgradedetail());

        Usersgradedetail result = userGradesDetailsService.getUserGradesByUserId(new User());
        Assertions.assertEquals(new Usersgradedetail(), result);
    }

    @Test
    void testCheckIfDetailsExistsByUserId() {
        when(usersgradedetailRepository.existsUsersgradedetailByUserid(any())).thenReturn(true);

        boolean result = userGradesDetailsService.checkIfDetailsExistsByUserId(0);
        Assertions.assertEquals(true, result);
    }
}

