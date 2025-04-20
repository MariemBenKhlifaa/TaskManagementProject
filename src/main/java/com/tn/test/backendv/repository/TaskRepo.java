package com.tn.test.backendv.repository;

import com.tn.test.backendv.dto.TaskResponse;
import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskRepo extends JpaRepository<Task, Long> {
    public List<Task> findByproject(Project project);
}
