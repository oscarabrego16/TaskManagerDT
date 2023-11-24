package com.rodriguezlazo.tasksmanager.services;

import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewTaskDTO;
import com.rodriguezlazo.tasksmanager.entities.*;

public interface TaskService extends GenericService<Task, NewTaskDTO> {
    Task saveTask(NewTaskDTO dto, Project project, Category category, TaskStatus status, TaskLabel label, TaskPriority priority);
}
