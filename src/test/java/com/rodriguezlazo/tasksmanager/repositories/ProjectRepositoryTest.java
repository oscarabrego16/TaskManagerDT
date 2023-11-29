package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.Project;

import com.rodriguezlazo.tasksmanager.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    void findProjectById() {
//given
        User user02= new User("Oscar", "lazo", "oara", "aaaaaaa");
        userRepository.save(user02);
        Project project01= new Project("Proyecto de oscar","descripcion del proj de oscar", new Date(2024,9,19), new Date(2024,9,25), user02);
        projectRepository.save(project01);


//when
        Long id = 1L;
        Project expected =projectRepository.findById(id).get();
        System.out.println(expected.toString());
//then
        assertThat(expected.getProject_id().equals(id)).isTrue();
    }

}

