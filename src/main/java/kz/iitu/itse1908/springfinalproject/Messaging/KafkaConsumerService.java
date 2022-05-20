package kz.iitu.itse1908.springfinalproject.Messaging;

import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(Notification notification){
        System.out.println("Consuming the message: " + notification.getText());
    }
}