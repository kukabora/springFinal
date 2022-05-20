package kz.iitu.itse1908.springfinalproject.Messaging;

import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Notification> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Notification> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Notification notification) {
        System.out.println("Producing the message: " + notification);
        kafkaTemplate.send("messages", notification);
    }
}