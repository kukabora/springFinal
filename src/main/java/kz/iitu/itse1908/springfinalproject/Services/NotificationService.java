package kz.iitu.itse1908.springfinalproject.Services;

import kz.iitu.itse1908.springfinalproject.Entities.Group;
import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    final
    NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void insert(Notification notification){
        notificationRepository.save(notification);
    }

    public void delete(Notification notification){
        notificationRepository.delete(notification);
    }

    public Iterable<Notification> getAll(){
        return notificationRepository.findAll();
    }

    public void saveAll(Iterable<Notification> notifications){
        notificationRepository.saveAll(notifications);
    }

    public Notification findById(int id){return notificationRepository.findNotificationById(id);}
}
