package com.yasir.tasks.services.impl;

import com.yasir.tasks.domain.entities.TaskList;
import com.yasir.tasks.repositories.TaskListRepository;
import com.yasir.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private  final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(null != taskList.getTasks()){
            throw new IllegalArgumentException("Task list  already  has an ID!");
        }
        if(null == taskList.getTitle() ||taskList.getTitle().isBlank()){
            throw  new IllegalArgumentException("Task list title must be Present!");
        }
        LocalDateTime now  = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }
}
