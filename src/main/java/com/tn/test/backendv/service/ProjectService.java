package com.tn.test.backendv.service;

import com.tn.test.backendv.Mapper.ProjectMapper;
import com.tn.test.backendv.exception.ResourceNotFoundException;
import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.repository.ProjectRepo;
import com.tn.test.backendv.dto.ProjectRequest;
import com.tn.test.backendv.dto.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements ProjectInterface{

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Project project = projectMapper.ToEntity(request);
        return projectMapper.toResponse(projectRepo.save(project)) ;
    }

    @Override
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project with ID " + projectId + " not found"));
        Project projectupdate = projectMapper.ToEntity(request);

        project.setDescription(projectupdate.getDescription());
        project.setName(projectupdate.getName());


        return projectMapper.toResponse(projectRepo.save(project));
    }

    @Override
    public ProjectResponse getProjectById(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project with ID " + projectId + " not found"));

        return projectMapper.toResponse(project);
    }

    @Override

        public Page<ProjectResponse> getAllProjects(int page, int size) {
            PageRequest pageRequest = PageRequest.of(page, size);
            return projectRepo.findAll(pageRequest)
                    .map(projectMapper::toResponse);
        }


    @Override
    public void deleteProject(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project with ID " + projectId + " not found"));
        projectRepo.delete(project);
    }
}
