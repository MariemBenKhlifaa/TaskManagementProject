package com.tn.test.backendv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    // Statut (TO_DO, IN_PROGRESS, DONE) -> via Enum
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // Priorité (HIGH, MEDIUM, LOW) -> via Enum
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    // Assignation (la personne qui doit faire la tâche)
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignee;

    // Lien vers le projet
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // Historique
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
