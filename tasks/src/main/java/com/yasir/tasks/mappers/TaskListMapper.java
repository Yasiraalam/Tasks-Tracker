package com.yasir.tasks.mappers;

import com.yasir.tasks.domain.dto.TaskListDto;
import com.yasir.tasks.domain.entities.Task;
import com.yasir.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
