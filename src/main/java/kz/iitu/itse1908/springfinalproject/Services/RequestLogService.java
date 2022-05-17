package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Assesment;
import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import kz.iitu.itse1908.springfinalproject.Repositories.AssesmentRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RequestsLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

@Service
public class RequestLogService {

    final
    RequestsLogRepository requestsLogRepository;

    public RequestLogService(RequestsLogRepository requestsLogRepository) {
        this.requestsLogRepository = requestsLogRepository;
    }

    public void insert(RequestsLog requestsLog){
        requestsLogRepository.save(requestsLog);
    }

    public void delete(RequestsLog requestsLog){
        requestsLogRepository.delete(requestsLog);
    }

    public Iterable<RequestsLog> getAll(){
        return requestsLogRepository.findAll();
    }

    public void saveAll(Iterable<RequestsLog> requestsLogs){
        requestsLogRepository.saveAll(requestsLogs);
    }

    public RequestsLog findById(int id) {return requestsLogRepository.findRequestsLogById(id);}
}
