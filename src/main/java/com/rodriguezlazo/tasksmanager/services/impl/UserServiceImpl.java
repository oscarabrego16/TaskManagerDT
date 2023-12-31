package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.ModifyUserDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.repositories.UserRepository;
import com.rodriguezlazo.tasksmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User save(NewUserDTO dto) {
        User usuario = new User();
        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        return repository.save(usuario);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findOneByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User modifyUserById(ModifyUserDTO newUserDTO) {
        Optional<User> user;
        user = repository.findById(newUserDTO.getId());
        user.get().setName(newUserDTO.getName());
        user.get().setLastname(newUserDTO.getLastname());
        user.get().setPassword(newUserDTO.getPassword());
        user.get().setUsername(newUserDTO.getUsername());
        return repository.save(user.get());
    }


}
