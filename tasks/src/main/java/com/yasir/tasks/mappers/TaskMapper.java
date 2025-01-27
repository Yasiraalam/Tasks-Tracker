package com.yasir.tasks.mappers;

import com.yasir.tasks.domain.dto.TaskDto;
import com.yasir.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
