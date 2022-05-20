package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Repositories.NotificationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Mock
    NotificationRepository notificationRepository;
    @Mock
    Logger logger;
    @InjectMocks
    NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        notificationService.preDestroy();
    }

    @Test
    void testInsert() {
        notificationService.insert(new Notification());
    }

    @Test
    void testDelete() {
        notificationService.delete(new Notification());
    }

    @Test
    void testGetAll() {
        Iterable<Notification> result = notificationService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        notificationService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(notificationRepository.findNotificationById(anyInt())).thenReturn(new Notification());

        Notification result = notificationService.findById(0);
        Assertions.assertEquals(new Notification(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme