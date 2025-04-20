package com.tn.test.backendv.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;




}
