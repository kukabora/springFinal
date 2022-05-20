package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.TaskGroup;
import kz.iitu.itse1908.springfinalproject.Repositories.TaskGroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class TaskGroupServiceTest {
    @Mock
    TaskGroupRepository taskGroupRepository;
    @Mock
    Logger logger;
    @InjectMocks
    TaskGroupService taskGroupService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        taskGroupService.preDestroy();
    }

    @Test
    void testInsert() {
        taskGroupService.insert(new TaskGroup());
    }

    @Test
    void testDelete() {
        taskGroupService.delete(new TaskGroup());
    }

    @Test
    void testGetAll() {
        Iterable<TaskGroup> result = taskGroupService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        taskGroupService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(taskGroupRepository.findTaskGroupById(anyInt())).thenReturn(new TaskGroup());

        TaskGroup result = taskGroupService.findById(0);
        Assertions.assertEquals(new TaskGroup(), result);
    }

    @Test
    void testFindTaskGroupByGroupid() {
        when(taskGroupRepository.findAllByGroupid(any())).thenReturn(null);

        Iterable<TaskGroup> result = taskGroupService.findTaskGroupByGroupid(new Group());
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme