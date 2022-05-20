package kz.iitu.itse1908.springfinalproject.Controllers;


import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Messaging.KafkaConsumerService;
import kz.iitu.itse1908.springfinalproject.Messaging.KafkaProducerService;
import kz.iitu.itse1908.springfinalproject.Services.NotificationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messaging")
public class MessagingController {

    final
    KafkaProducerService kafkaProducerService;

    final KafkaConsumerService kafkaConsumerService;

    final
    NotificationService notificationService;

    public MessagingController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService, NotificationService notificationService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@RequestBody Notification notification) {
        kafkaProducerService.produce(notification);
        notificationService.insert(notification);
        return "Message has been ssended successfully!";
    }

    @GetMapping(value = "/getMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(@RequestBody Notification notification) {
        kafkaConsumerService.consume(notification);
        notificationService.insert(notification);
        return "Message has been consumed successfully!";
    }

}
