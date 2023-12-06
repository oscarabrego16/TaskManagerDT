package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.NewTaskDTO;
import com.rodriguezlazo.tasksmanager.entities.*;
import com.rodriguezlazo.tasksmanager.repositories.TaskRepository;
import com.rodriguezlazo.tasksmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(NewTaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDue_date(dto.getDue_date());

        return task;
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Task saveTask(NewTaskDTO dto, Project project, Category category, TaskStatus status, TaskLabel label, TaskPriority priority) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDue_date(dto.getDue_date());
        task.setProject(project);
        task.setTaskCategory(category);
        task.setTaskStatus(status);
        task.setTaskLabel(label);
        task.setTaskPriority(priority);
        taskRepository.save(task);
        return task;
    }
}
