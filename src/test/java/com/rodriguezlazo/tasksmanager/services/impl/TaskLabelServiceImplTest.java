package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.repositories.TaskLabelRepository;
import com.rodriguezlazo.tasksmanager.repositories.UserRepository;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import com.rodriguezlazo.tasksmanager.services.TaskService;
import com.rodriguezlazo.tasksmanager.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TaskLabelServiceImplTest {

    @Autowired
    TaskLabelService taskLabelService;
    @MockBean
    TaskLabelRepository taskLabelRepository;

    @Test
    void findOneByName() {
        taskLabelService.findOneByName(anyString());
        verify(taskLabelRepository).findOneByName(anyString());
    }

}
