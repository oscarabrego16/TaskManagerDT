package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.NewCategoryDTO;
import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.repositories.CategoryRepository;
import com.rodriguezlazo.tasksmanager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;


    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Category save(NewCategoryDTO dto) {
        return repository.save(new Category(dto.getName()));
    }

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Category findOneByName(String name) {
        return repository.findCategoryByName(name);
    }
}
