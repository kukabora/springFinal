package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class GroupServiceTest {
    @Mock
    GroupRepository groupRepository;
    @Mock
    Logger logger;
    @InjectMocks
    GroupService groupService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        groupService.preDestroy();
    }

    @Test
    void testInsertNewGroup() {
        groupService.insertNewGroup(new Group());
    }

    @Test
    void testDeleteGroup() {
        groupService.deleteGroup(new Group());
    }

    @Test
    void testGetAll() {
        Iterable<Group> result = groupService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        groupService.saveAll(null);
    }

    @Test
    void testFindGroupByName() {
        when(groupRepository.findGroupByName(anyString())).thenReturn(new Group());

        Group result = groupService.findGroupByName("name");
        Assertions.assertEquals(new Group(), result);
    }

    @Test
    void testFindGroupById() {
        when(groupRepository.findGroupById(anyInt())).thenReturn(new Group());

        Group result = groupService.findGroupById(0);
        Assertions.assertEquals(new Group(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme