package com.example.HealthTracker.service;


import com.example.HealthTracker.model.Notification;
import com.example.HealthTracker.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification addNotification(Notification notification, String username) {
        notification.setUsername(username);
        notification.setCreatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByUsername(String username) {
        return notificationRepository.findByUsername(username);
    }
}

