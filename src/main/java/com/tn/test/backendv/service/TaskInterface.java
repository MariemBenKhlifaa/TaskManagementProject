package com.tn.test.backendv.service;

import com.tn.test.backendv.dto.TaskRequest;
import com.tn.test.backendv.dto.TaskResponse;
import com.tn.test.backendv.model.Task;

import java.util.List;

public interface TaskInterface {
    TaskResponse createTask(TaskRequest task, Long projectId);
    TaskResponse updateTask(Long TaskId, TaskRequest request);
    List<TaskResponse>  getTaskById(Long TaskId);
    void deleteProject(Long TaskId );
}
