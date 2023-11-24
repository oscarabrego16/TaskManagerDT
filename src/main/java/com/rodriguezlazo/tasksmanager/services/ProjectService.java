package com.rodriguezlazo.tasksmanager.services;

import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.entities.Project;
import com.rodriguezlazo.tasksmanager.entities.User;

public interface ProjectService extends GenericService<Project, NewProjectDTO> {
    Project saveProject(NewProjectDTO dto, User user);
    //Project findBy(Long id);
}
