package com.tn.test.backendv.controller;

import com.tn.test.backendv.dto.TaskRequest;
import com.tn.test.backendv.dto.TaskResponse;
import com.tn.test.backendv.model.Task;
import com.tn.test.backendv.service.TaskInterface;
import com.tn.test.backendv.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
   private TaskInterface taskInterface;

   TaskController(TaskInterface taskInterface) {
       this.taskInterface = taskInterface;
   }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<TaskResponse>> getTaskByid(@PathVariable Long projectId) {
        List<TaskResponse> tasks = taskInterface.getTaskById(projectId);
        return ResponseEntity.ok(tasks);
    }


    @PostMapping("/{projectId}")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request , @PathVariable Long projectId ) {
        TaskResponse created = taskInterface.createTask(request,projectId);
        return ResponseEntity.ok(created);
    }


}
