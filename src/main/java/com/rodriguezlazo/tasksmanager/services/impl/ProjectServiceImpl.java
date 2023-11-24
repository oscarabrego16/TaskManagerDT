package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.NewCategoryDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.entities.Project;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.repositories.ProjectRepository;
import com.rodriguezlazo.tasksmanager.repositories.UserRepository;
import com.rodriguezlazo.tasksmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(NewProjectDTO dto) {
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public Project saveProject(NewProjectDTO dto, User user){
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStart_date());
        project.setEndDate(dto.getEnd_date());
        project.setDueno(user);
        return projectRepository.save(project);
    }



    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
