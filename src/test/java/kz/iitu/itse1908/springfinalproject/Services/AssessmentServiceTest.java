package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.Task;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;

import static org.mockito.Mockito.*;

class AssessmentServiceTest {
    @Mock
    Logger logger;
    @Mock
    AssesmentRepository assesmentRepository;
    @InjectMocks
    AssessmentService assessmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreDestroy() {
        assessmentService.preDestroy();
    }

    @Test
    void testInsertNewAssesment() {
        assessmentService.insertNewAssesment(new Assesment());
    }

    @Test
    void testDeleteAssessment() {
        assessmentService.deleteAssessment(new Assesment());
    }

    @Test
    void testGetAll() {
        Iterable<Assesment> result = assessmentService.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveAll() {
        assessmentService.saveAll(null);
    }

    @Test
    void testFindById() {
        when(assesmentRepository.findAssesmentById(anyInt())).thenReturn(new Assesment());

        Assesment result = assessmentService.findById(0);
        Assertions.assertEquals(new Assesment(), result);
    }

    @Test
    void testFindAllByAssessorId() {
        when(assesmentRepository.findAssesmentsByAssessorid(any())).thenReturn(List.of(new Assesment()));

        Iterable<Assesment> result = assessmentService.findAllByAssessorId(new User());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCheckIfAlreadyAssessed() {
        when(assesmentRepository.existsByAssessoridAndTaskid(any(), any())).thenReturn(true);

        boolean result = assessmentService.checkIfAlreadyAssessed(new User(), new Task());
        Assertions.assertEquals(true, result);
    }
}

