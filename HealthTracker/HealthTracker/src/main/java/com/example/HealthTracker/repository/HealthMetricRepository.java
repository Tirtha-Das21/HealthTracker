package com.example.HealthTracker.repository;

import com.example.HealthTracker.model.HealthMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetric, Long> {
    List<HealthMetric> findByUsername(String username);
    List<HealthMetric> findByUsernameAndDateAfter(String username, LocalDate date);
}