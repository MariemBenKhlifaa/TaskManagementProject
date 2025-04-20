package com.tn.test.backendv.dto;



import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectRequest {
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


}
