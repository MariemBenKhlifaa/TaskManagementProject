package com.tn.test.backendv.controller;

import com.tn.test.backendv.exception.ResourceNotFoundException;
import com.tn.test.backendv.service.ProjectService;
import com.tn.test.backendv.dto.ProjectRequest;
import com.tn.test.backendv.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    // Injection par constructeur
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Récupérer tous les projets (avec pagination).
     * Exemple d'appel : GET /api/projects?page=0&size=5
     */
    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<ProjectResponse> projectPage = projectService.getAllProjects(page, size);
        return ResponseEntity.ok(projectPage);
    }

    /**
     * Récupérer un projet par son ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id) {
        ProjectResponse response = projectService.getProjectById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Créer un nouveau projet.
     */
    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request) {
        ProjectResponse created = projectService.createProject(request);
        return ResponseEntity.ok(created);
    }

    /**
     * Mettre à jour un projet existant.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequest request
    ) {
        ProjectResponse updated = projectService.updateProject(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
