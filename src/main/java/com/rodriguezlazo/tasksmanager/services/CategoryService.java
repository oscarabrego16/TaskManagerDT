package com.rodriguezlazo.tasksmanager.services;

import com.rodriguezlazo.tasksmanager.dtos.NewCategoryDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.User;

public interface CategoryService extends GenericService<Category, NewCategoryDTO> {
    Category findOneByName(String name);
}
