package com.example.HealthTracker.service;


import com.example.HealthTracker.model.HealthMetric;
import com.example.HealthTracker.repository.HealthMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HealthMetricService {
    @Autowired
    private HealthMetricRepository repository;

    public HealthMetric saveMetric(HealthMetric metric, String username) {
        metric.setUsername(username);
        metric.setDate(LocalDate.now());
        return repository.save(metric);
    }

    public List<HealthMetric> getMetricsByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Map<String, Object> calculatePerformance(String username) {
        List<HealthMetric> metrics = repository.findByUsernameAndDateAfter(username, LocalDate.now().minusWeeks(1));
        int totalSteps = metrics.stream().mapToInt(HealthMetric::getSteps).sum();
        int totalCalories = metrics.stream().mapToInt(HealthMetric::getCaloriesBurned).sum();
        double avgSleep = metrics.stream().mapToInt(HealthMetric::getSleepHours).average().orElse(0);

        Map<String, Object> trends = new HashMap<>();
        trends.put("totalSteps", totalSteps);
        trends.put("totalCalories", totalCalories);
        trends.put("averageSleep", avgSleep);

        return trends;
    }
}