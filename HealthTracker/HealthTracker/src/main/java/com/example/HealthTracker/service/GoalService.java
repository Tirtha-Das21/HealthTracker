package com.example.HealthTracker.service;

import com.example.HealthTracker.model.Goal;
import com.example.HealthTracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal addGoal(Goal goal, String username) {
        goal.setUsername(username);
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsByUsername(String username) {
        return goalRepository.findByUsername(username);
    }
}

