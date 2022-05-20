package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Repositories.TestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class TestServiceTest {
    @Mock
    TestRepository testRepository;
    @Mock
    Logger logger;
    @InjectMocks
    TestService testService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        testService.preDestroy();
    }

    @Test
    void testInsert() {
        testService.insert(new kz.iitu.itse1908.springfinalproject.Entities.Test());
    }

    @Test
    void testDelete() {
        testService.delete(new kz.iitu.itse1908.springfinalproject.Entities.Test());
    }

    @Test
    void testGetAll() {
        Iterable<kz.iitu.itse1908.springfinalproject.Entities.Test> result = testService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        testService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(testRepository.findTestById(anyInt())).thenReturn(new kz.iitu.itse1908.springfinalproject.Entities.Test());

        kz.iitu.itse1908.springfinalproject.Entities.Test result = testService.findById(0);
        Assertions.assertEquals(new kz.iitu.itse1908.springfinalproject.Entities.Test(), result);
    }

    @Test
    void testExistsById() {
        when(testRepository.existsById(anyInt())).thenReturn(true);

        boolean result = testService.existsById(0);
        Assertions.assertEquals(true, result);
    }
}

