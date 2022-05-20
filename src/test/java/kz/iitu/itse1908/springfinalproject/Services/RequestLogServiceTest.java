package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import kz.iitu.itse1908.springfinalproject.Repositories.RequestsLogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class RequestLogServiceTest {
    @Mock
    RequestsLogRepository requestsLogRepository;
    @Mock
    Logger logger;
    @InjectMocks
    RequestLogService requestLogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        requestLogService.preDestroy();
    }

    @Test
    void testInsert() {
        requestLogService.insert(new RequestsLog());
    }

    @Test
    void testDelete() {
        requestLogService.delete(new RequestsLog());
    }

    @Test
    void testGetAll() {
        Iterable<RequestsLog> result = requestLogService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        requestLogService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(requestsLogRepository.findRequestsLogById(anyInt())).thenReturn(new RequestsLog());

        RequestsLog result = requestLogService.findById(0);
        Assertions.assertEquals(new RequestsLog(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme