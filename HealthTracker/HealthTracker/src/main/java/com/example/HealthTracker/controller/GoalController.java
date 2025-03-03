package com.example.HealthTracker.controller;

import com.example.HealthTracker.model.Goal;
import com.example.HealthTracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<Goal> addGoal(@RequestBody Goal goal, @RequestHeader("username") String username) {
        return ResponseEntity.ok(goalService.addGoal(goal, username));
    }

    @GetMapping
    public ResponseEntity<List<Goal>> getGoals(@RequestHeader("username") String username) {
        return ResponseEntity.ok(goalService.getGoalsByUsername(username));
    }
}