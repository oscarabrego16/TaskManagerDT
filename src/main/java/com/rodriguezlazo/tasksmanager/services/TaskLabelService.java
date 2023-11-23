package com.rodriguezlazo.tasksmanager.services;

import com.rodriguezlazo.tasksmanager.dtos.NewTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.entities.TaskLabel;

public interface TaskLabelService extends GenericService<TaskLabel, NewTaskLabelDTO> {
    TaskLabel findOneByName(String name);
}
