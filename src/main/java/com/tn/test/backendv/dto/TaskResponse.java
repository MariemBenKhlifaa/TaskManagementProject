package com.tn.test.backendv.dto;

import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.model.TaskPriority;
import com.tn.test.backendv.model.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private TaskPriority priority;
    // Projet
    private Project project;


}
