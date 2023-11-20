package com.rodriguezlazo.tasksmanager.services;

import java.util.Optional;

public interface GenericService<E,T> {
    Optional<E> findById(Long id);
    E save(T dto);
    Iterable<E> findAll();
    void deleteById(Long id);

}
