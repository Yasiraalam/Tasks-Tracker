package com.yasir.tasks.controllers;


import com.yasir.tasks.domain.dto.TaskListDto;
import com.yasir.tasks.domain.entities.TaskList;
import com.yasir.tasks.mappers.TaskListMapper;
import com.yasir.tasks.services.TaskListService;
import com.yasir.tasks.services.impl.TaskListServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @PostMapping
    public  TaskListDto createTaskList(@RequestBody TaskListDto taskListDto){
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId){
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping(path= "/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDto taskListDto
    ){
        TaskList updateTaskList = taskListService.updateTaskList(
                taskListId,
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(updateTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public String DeleteTaskList(@PathVariable("task_list_id") UUID taskListId){
        taskListService.deleteTaskList(taskListId);
        return "deleted successfully!";
    }

}
