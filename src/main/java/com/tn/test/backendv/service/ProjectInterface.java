package com.tn.test.backendv.service;

import com.tn.test.backendv.dto.ProjectRequest;
import com.tn.test.backendv.dto.ProjectResponse;
import org.springframework.data.domain.Page;

public interface ProjectInterface {
    ProjectResponse createProject(ProjectRequest request);
    ProjectResponse updateProject(Long projectId, ProjectRequest request);
    ProjectResponse getProjectById(Long projectId);
    Page<ProjectResponse> getAllProjects(int page, int size);
    void deleteProject(Long projectId);
}
