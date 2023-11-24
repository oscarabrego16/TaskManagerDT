package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}