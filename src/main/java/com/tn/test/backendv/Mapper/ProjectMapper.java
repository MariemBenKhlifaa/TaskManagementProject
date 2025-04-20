package com.tn.test.backendv.Mapper;

import com.tn.test.backendv.model.Project;
import com.tn.test.backendv.dto.ProjectRequest;
import com.tn.test.backendv.dto.ProjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project ToEntity(ProjectRequest project);
    ProjectResponse toResponse(Project entity);

}
