package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.ModifyTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.TaskLabel;
import com.rodriguezlazo.tasksmanager.repositories.TaskLabelRepository;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskLabelServiceImpl implements TaskLabelService {

    @Autowired
    private TaskLabelRepository repository;

    @Override
    public Optional<TaskLabel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TaskLabel save(NewTaskLabelDTO dto) {
        return repository.save(new TaskLabel(dto.getName()));

    }

    @Override
    public Iterable<TaskLabel> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TaskLabel findOneByName(String name) {
        return repository.findOneByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TaskLabel modifyById(ModifyTaskLabelDTO modifyTaskLabelDTO) {
        Optional<TaskLabel> label;
        label= repository.findById(modifyTaskLabelDTO.getLabel_id());
        label.get().setName(modifyTaskLabelDTO.getName());
        return repository.save(label.get());
    }
}
