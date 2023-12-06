package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.repositories.UserRepository;
import com.rodriguezlazo.tasksmanager.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
@SpringBootTest
class UserServiceImplTest {
    @MockBean
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    void findOneByUsername() {
        userService.findOneByUsername(anyString());
        verify(userRepository).findUserByUsername(anyString());
    }
}