package com.yasir.tasks.services;

import com.yasir.tasks.domain.entities.Task;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId,Task task);
    Optional<Task> getTask(UUID taskListId, UUID taskId);
    Task updateTask(UUID taskListId,UUID taskId,Task task);
    void deleteTask(UUID taskListId, UUID taskId);
}
