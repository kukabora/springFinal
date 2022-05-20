package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import kz.iitu.itse1908.springfinalproject.Repositories.TestquestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class TestQuestionServiceTest {
    @Mock
    TestquestionRepository testquestionRepository;
    @Mock
    Logger logger;
    @InjectMocks
    TestQuestionService testQuestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        testQuestionService.preDestroy();
    }

    @Test
    void testInsert() {
        testQuestionService.insert(new Testquestion());
    }

    @Test
    void testDelete() {
        testQuestionService.delete(new Testquestion());
    }

    @Test
    void testGetAll() {
        Iterable<Testquestion> result = testQuestionService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        testQuestionService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(testquestionRepository.findTestquestionById(anyInt())).thenReturn(new Testquestion());

        Testquestion result = testQuestionService.findById(0);
        Assertions.assertEquals(new Testquestion(), result);
    }

    @Test
    void testFindAllByTestId() {
        when(testquestionRepository.getAllByTestid(any())).thenReturn(null);

        Iterable<Testquestion> result = testQuestionService.findAllByTestId(new kz.iitu.itse1908.springfinalproject.Entities.Test());
        Assertions.assertEquals(null, result);
    }
}

