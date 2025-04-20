package com.tn.test.backendv.Mapper;


import com.tn.test.backendv.model.Task;
import com.tn.test.backendv.dto.TaskRequest;
import com.tn.test.backendv.dto.TaskResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task ToEntity(TaskRequest taskRequest);
    TaskResponse toResponse(Task entity);
    List<TaskResponse>  toResponseList(List<Task> entityList);
}
