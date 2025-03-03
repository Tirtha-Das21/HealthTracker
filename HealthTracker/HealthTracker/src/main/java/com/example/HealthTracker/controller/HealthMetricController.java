package com.example.HealthTracker.controller;

import com.example.HealthTracker.model.HealthMetric;
import com.example.HealthTracker.service.HealthMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/metrics")
public class HealthMetricController {
    @Autowired
    private HealthMetricService service;

    @PostMapping
    public ResponseEntity<HealthMetric> addMetric(@RequestBody HealthMetric metric,
                                                  @RequestHeader("username") String username) {
        return ResponseEntity.ok(service.saveMetric(metric, username));
    }

    @GetMapping
    public ResponseEntity<List<HealthMetric>> getMetrics(@RequestHeader("username") String username) {
        return ResponseEntity.ok(service.getMetricsByUsername(username));
    }

    @GetMapping("/performance")
    public ResponseEntity<Map<String, Object>> getTrends(@RequestHeader("username") String username) {
        return ResponseEntity.ok(service.calculatePerformance(username));
    }
}
