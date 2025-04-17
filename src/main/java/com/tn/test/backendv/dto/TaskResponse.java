package com.tn.test.projectManagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private String priority;

    // Assignee
    private UserResponse assignee;

    // Projet
    private ProjectResponse project;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
