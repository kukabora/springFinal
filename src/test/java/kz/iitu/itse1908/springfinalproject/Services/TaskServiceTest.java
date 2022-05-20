package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    Logger logger;
    @InjectMocks
    TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        taskService.preDestroy();
    }

    @Test
    void testInsert() {
        taskService.insert(new Task());
    }

    @Test
    void testDelete() {
        taskService.delete(new Task());
    }

    @Test
    void testGetAll() {
        Iterable<Task> result = taskService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        taskService.saveAll(null);
    }

    @Test
    void testFindAllById() {
        when(taskRepository.findAllById(any())).thenReturn(null);

        Iterable<Task> result = taskService.findAllById(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindById() {
        when(taskRepository.findTaskById(anyInt())).thenReturn(new Task());

        Task result = taskService.findById(0);
        Assertions.assertEquals(new Task(), result);
    }

    @Test
    void testFindByTestId() {
        when(taskRepository.findByTestid(any())).thenReturn(new Task());

        Task result = taskService.findByTestId(new kz.iitu.itse1908.springfinalproject.Entities.Test());
        Assertions.assertEquals(new Task(), result);
    }

    @Test
    void testExistsById() {
        when(taskRepository.existsById(anyInt())).thenReturn(true);

        boolean result = taskService.existsById(0);
        Assertions.assertEquals(true, result);
    }
}

