package com.example.HealthTracker.controller;

import com.example.HealthTracker.model.Notification;
import com.example.HealthTracker.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification,
                                                        @RequestHeader("username") String username) {
        Notification savedNotification = notificationService.addNotification(notification, username);
        return ResponseEntity.ok(savedNotification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications(@RequestHeader("username") String username) {
        return ResponseEntity.ok(notificationService.getNotificationsByUsername(username));
    }
}
