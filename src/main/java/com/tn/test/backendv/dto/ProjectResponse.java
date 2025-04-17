package com.tn.test.projectManagement.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    // Infos manager
    private UserResponse manager;
    // ou juste managerId si on veut faire un second call
    // ou managerName si on veut être plus concis

    // Liste des membres
    private List<UserResponse> members;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
