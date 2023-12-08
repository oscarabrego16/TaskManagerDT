package com.rodriguezlazo.tasksmanager.services;


import com.rodriguezlazo.tasksmanager.dtos.ModifyUserDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.User;

public interface UserService extends GenericService<User, NewUserDTO> {
    User findOneByUsername(String username);
    User modifyUserById (ModifyUserDTO dto);

}
