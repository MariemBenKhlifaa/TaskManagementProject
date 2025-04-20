package com.tn.test.backendv.service;

import com.tn.test.backendv.Mapper.TaskMapper;
import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.model.Task;
import com.tn.test.backendv.repository.ProjectRepo;
import com.tn.test.backendv.repository.TaskRepo;
import com.tn.test.backendv.dto.TaskRequest;
import com.tn.test.backendv.dto.TaskResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements TaskInterface{

    @Autowired
    TaskRepo   taskRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    TaskMapper taskMapper;

    @Transactional
    @Override
    public TaskResponse createTask(TaskRequest taskRequest, Long projectId) {
        Project project = projectRepo.findById(projectId).get();
        Task task = taskMapper.ToEntity(taskRequest);
        task.setProject(project);
       // project.getTasks().add(task);
        taskRepo.save(task);
        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long TaskId, TaskRequest taskRequest) {

        Task task = taskRepo.findById(TaskId).get();
       Task tasknew = taskMapper.ToEntity(taskRequest);
       task.setDescription(tasknew.getDescription());
       task.setPriority(tasknew.getPriority());
       taskRepo.save(task);
        return taskMapper.toResponse(task);
    }

    @Override
    public List<TaskResponse>  getTaskById(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow();
        List<Task> tasks = taskRepo.findByproject(project);
        return taskMapper.toResponseList(tasks);
    }



    @Override
    public void deleteProject(Long TaskId) {
      taskRepo.deleteById(TaskId);
    }
}
