package com.yasir.tasks.repositories;

import com.yasir.tasks.domain.entities.Task;
import com.yasir.tasks.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskListRepository  extends JpaRepository<TaskList, UUID> {

}
