package com.yasir.tasks.controllers;


import com.yasir.tasks.domain.dto.TaskListDto;
import com.yasir.tasks.mappers.TaskListMapper;
import com.yasir.tasks.services.TaskListService;
import com.yasir.tasks.services.impl.TaskListServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private  final TaskListService taskListService;
    private  final TaskListMapper taskListMapper;

    public TaskListController(TaskListServiceImpl taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
