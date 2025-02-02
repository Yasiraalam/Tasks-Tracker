package com.yasir.tasks.services;

import com.yasir.tasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList>  listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
