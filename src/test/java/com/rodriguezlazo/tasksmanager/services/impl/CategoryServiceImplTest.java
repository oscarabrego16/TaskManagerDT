package com.rodriguezlazo.tasksmanager.services.impl;


import com.rodriguezlazo.tasksmanager.repositories.CategoryRepository;
import com.rodriguezlazo.tasksmanager.repositories.TaskLabelRepository;
import com.rodriguezlazo.tasksmanager.services.CategoryService;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;
    @MockBean
    CategoryRepository categoryRepository;

    @Test
    void findOneByName() {
        categoryService.findOneByName(anyString());
        verify(categoryRepository).findCategoryByName(anyString());
    }

}
