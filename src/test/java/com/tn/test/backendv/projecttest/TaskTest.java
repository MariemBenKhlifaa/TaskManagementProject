package com.tn.test.backendv.projecttest;

import com.tn.test.backendv.Mapper.TaskMapper;
import com.tn.test.backendv.dto.TaskRequest;
import com.tn.test.backendv.dto.TaskResponse;
import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.model.Task;
import com.tn.test.backendv.repository.ProjectRepo;
import com.tn.test.backendv.repository.TaskRepo;
import com.tn.test.backendv.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TaskTest {
    @Mock
    TaskRepo taskRepo;
    @Mock
    TaskMapper taskMapper;
    @Mock
    ProjectRepo projectRepo;
    @InjectMocks
    TaskService taskService;

    Task testTask = new Task();
    TaskRequest testTaskRequest = new TaskRequest();
    TaskResponse testTaskResponse = new TaskResponse();
    Project testProject = new Project();
    List<TaskResponse> taskResponsesList = new ArrayList<>();
    List<Task> taskList = new ArrayList<>();

    @BeforeEach
    void SetUp(){

        testProject.setId(1L);
        testTaskRequest.setTitle("task1");
        testTaskRequest.setDescription("task1");
        testTaskRequest.setProject(testProject);
        testTaskRequest.setProject(testProject);
        testTaskResponse.setTitle("task1");
        testTaskResponse.setDescription("task1");
        testTaskResponse.setProject(testProject);
        taskList.add(testTask);
        taskResponsesList.add(testTaskResponse);

    }
    @Test
    public  void testCreateTask(){
        // on simule la conversion d'un DTO en entité
        // 1- convertir le taskrequest on task
        Mockito.when(taskMapper.ToEntity(testTaskRequest)).thenReturn(testTask);
        // recuprer un projet
        Mockito.when(projectRepo.findById(testProject.getId())).thenReturn(Optional.of(testProject));
        testTask.setProject(testProject);
        // on simule le repository et sauvgarde le task
        Mockito.when(taskRepo.save(testTask)).thenReturn(testTask);

        Mockito.when(taskMapper.toResponse(testTask)).thenReturn(testTaskResponse);

        TaskResponse response = taskService.createTask(testTaskRequest, testProject.getId());
        // verifier qu'on a bien appeler
        Mockito.verify(taskMapper).ToEntity(testTaskRequest);
        Mockito.verify(projectRepo).findById(testProject.getId());
        Mockito.verify(taskRepo).save(testTask);
        Mockito.verify(taskMapper).toResponse(testTask);

        assertNotNull(response);
        assertEquals("task1", testTaskResponse.getTitle());
        assertEquals("task1", testTaskResponse.getDescription());
        assertEquals(testProject, testTaskResponse.getProject());



    }
    @Test
    public void getAllTasks(){
        Mockito.when(projectRepo.findById(testProject.getId())).thenReturn(Optional.of(testProject));

        Mockito.when(taskRepo.findByproject(testProject)).thenReturn(taskList);

        Mockito.when(taskMapper.toResponseList(taskList)).thenReturn(taskResponsesList);

        List<TaskResponse> result = taskService.getTaskById(testProject.getId());

        Mockito.verify(projectRepo).findById(testProject.getId());
        Mockito.verify(taskRepo).findByproject(testProject);
        Mockito.verify(taskMapper).toResponseList(taskList);

        assertNotNull(result);
        assertEquals(taskResponsesList.size(), result.size());
        assertEquals(taskResponsesList.get(0), result.get(0));
    }
}

