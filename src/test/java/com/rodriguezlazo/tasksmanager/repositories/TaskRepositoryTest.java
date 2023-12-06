package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class TaskRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskLabelRepository taskLabel;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    void findTaskById() {
//given
        TaskLabel label= new TaskLabel("parcial final");
        taskLabel.save(label);
        Category category= new Category("UCA");
        categoryRepository.save(category);
        User user03= new User("Emely", "lazo", "emmlyy", "aaaaaaa");
        userRepository.save(user03);
        Project project01= new Project("Proyecto de Emely","descripcion del proj de emely", new Date(2024,9,19), new Date(2024,9,25), user03);
        projectRepository.save(project01);

        Task task01 = new Task("Estudiar TEO", "Parcial 2 en proximo viernes", new Date(2023,12,1), project01, label, TaskPriority.HIGH, TaskStatus.TO_DO, category );
        taskRepository.save(task01);
//when
        Long id = 1L;
        Task expected =taskRepository.findById(id).get();
        System.out.println(expected.toString());
//then
        assertThat(expected.getId().equals(id)).isTrue();
    }
}
