package com.tn.test.projectManagement.dto;



import java.time.LocalDate;
import java.util.List;

public class ProjectRequest {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    // ID du manager, par exemple
    private Long managerId;

    // Liste d'ID de membres si on souhaite ajouter des utilisateurs lors de la création
    private List<Long> memberIds;
}
