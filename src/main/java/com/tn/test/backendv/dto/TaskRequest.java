package com.tn.test.backendv.dto;

import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.model.TaskPriority;
import com.tn.test.backendv.model.TaskStatus;
import com.tn.test.backendv.model.User;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TaskRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private TaskPriority priority;
    private Project project;

}
