package com.tn.test.backendv.projecttest;
import com.tn.test.backendv.Mapper.ProjectMapper;
import com.tn.test.backendv.dto.ProjectRequest;
import com.tn.test.backendv.dto.ProjectResponse;
import com.tn.test.backendv.exception.ResourceNotFoundException;
import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.repository.ProjectRepo;
import com.tn.test.backendv.service.ProjectService;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


// active mochito dans junit
@ExtendWith(MockitoExtension.class)
public class ProjectTest {

    // 2) @Mock crée un mock du ProjectRepository
    @Mock
    private ProjectRepo projectRepository;

    @Mock
    private ProjectMapper   projectMapper;

    // 3) @InjectMocks injecte le mock projectRepository dans ProjectService
    @InjectMocks
    private ProjectService projectService;

    private List<Project> projectList;
    private List<ProjectResponse> projectResponseList;
    private Project project;
    private ProjectResponse projectResponse;
    private ProjectRequest projectRequest;
    private Project project2;
    private ProjectResponse projectResponse2;
   @BeforeEach
   void SetUp(){
       project = new Project();
       project2 = new Project();
       projectRequest = new ProjectRequest();
       projectResponse = new ProjectResponse();
       projectResponse2 = new ProjectResponse();
       project.setName("test");
       project.setDescription("test");
       project.setId(1L);
       projectRequest.setName("test");
       projectRequest.setDescription("test");
       projectRequest.setId(1L);
       projectResponse.setId(1L);
       projectResponse.setName("test");
       projectResponse.setDescription("test");

       projectList = Arrays.asList(project, project2);

       projectResponseList = Arrays.asList(projectResponse, projectResponse2);


   }

    @Test
    public void testCreateProject() {

        //  Simulation de la conversion d'un DTO en entité
        // - Quand on appelle projectMapper.toEntity(request) => mappedProject

        Mockito.when(projectMapper.ToEntity(projectRequest)).thenReturn(project);

        // Simulation de la sauvegarde du projet dans la base de données :
        // - Quand on appelle projectRepository.save(mappedProject) => savedProject
        Mockito.when(projectRepository.save(Mockito.any(Project.class)))
                .thenReturn(project);
        // Simulation de la conversion de l'entité sauvegardée en DTO de réponse :
        // - Quand on appelle projectMapper.toResponse(savedProject) => responseDto
        Mockito.when(projectMapper.toResponse(project)).thenReturn(projectResponse);

        // 4.3) On dit à Mockito : "quand on appelle projectRepository.save(any Project), retourne savedProject"

        ProjectResponse result = projectService.createProject(projectRequest);


        // Vérifier qu'on a bien appelé le mapper pour la conversion Request -> Entité
        Mockito.verify(projectMapper).ToEntity(projectRequest);

        // Vérifier qu'on a bien appelé le repository pour sauver l'entité
        Mockito.verify(projectRepository).save(project);

        // Vérifier qu'on a bien appelé le mapper pour la conversion Entité -> Response
        Mockito.verify(projectMapper).toResponse(project);

        // Vérifier le résultat

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("test", result.getName());
        assertEquals("test", result.getDescription());

    }
    @Test
    public void testgetprojectSucces(){

        Mockito.when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        Mockito.when(projectMapper.toResponse(project)).thenReturn(projectResponse);
        ProjectResponse result = projectService.getProjectById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        Mockito.verify(projectRepository).findById(1L);
        Mockito.verify(projectMapper).toResponse(project);

    }
    @Test
    public void testGetByIdNotFound(){
        Mockito.when(projectRepository.findById(2L))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> projectService.getProjectById(2L));

        Mockito.verify(projectRepository,Mockito.times(1)).findById(2L);
        //pour verfier que la methode toResponse  n'est jamais appelé
        Mockito.verify(projectMapper, Mockito.never()).toResponse(Mockito.any(Project.class));

    }

    @Test

    public void getAllProjects(){
        int page = 0, size = 2;
        PageRequest pageRequest = PageRequest.of(page, size);
        // creation d'une page de project
        Page<Project> projectPage = new PageImpl<>(projectList, pageRequest, projectList.size());
        // simule la recuperation des pages de projet de la base de donné
        Mockito.when(projectRepository.findAll(pageRequest)).thenReturn(projectPage);
//simule conversion de chaque element de projectList en projectresponse
        Mockito.when(projectMapper.toResponse(projectList.get(0))).thenReturn(projectResponseList.get(0));
        Mockito.when(projectMapper.toResponse(projectList.get(1))).thenReturn(projectResponseList.get(1));

        Page<ProjectResponse> result = projectService.getAllProjects(page,size);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals(project.getId(), result.getContent().get(0).getId());
        assertEquals(project2.getId(), result.getContent().get(1).getId());

        Mockito.verify(projectRepository,Mockito.times(1)).findAll(pageRequest);
    }
    @Test
    void projectListEmpty(){
        int page = 0, size = 2;
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Project> emptyPage = Page.empty();

        Mockito.when(projectRepository.findAll(pageRequest)).thenReturn(emptyPage);
        Page<ProjectResponse> result = projectService.getAllProjects(page,size);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        Mockito.verify(projectRepository,Mockito.times(1)).findAll(pageRequest);
        Mockito.verify(projectMapper,Mockito.never()).toResponse(Mockito.any(Project.class));



    }
    @Test
    void deleteProject(){
       //simuler de la recuperation du projet avec id
       Mockito.when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
       //simuler la suppression du projet
       Mockito.doNothing().when(projectRepository).delete(project);
       //on fait l'appel de methode
       projectService.deleteProject(1L);
       //verfie le resultat
       assertNotNull(project);
       assertEquals(1L, project.getId());
       Mockito.verify(projectRepository,Mockito.times(1)).delete(project);


    }







}