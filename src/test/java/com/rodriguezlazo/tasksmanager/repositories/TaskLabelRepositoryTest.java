package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.TaskLabel;
import com.rodriguezlazo.tasksmanager.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TaskLabelRepositoryTest {


    @Autowired
    TaskLabelRepository taskLabelRepository;
    @Test
    void findTaskLabelByName() {
        String labelText= "parcial final";
//given
        TaskLabel label= new TaskLabel(labelText);
        taskLabelRepository.save(label);

//when

        TaskLabel expected =taskLabelRepository.findOneByName(labelText);
        System.out.println(expected.toString());
//then
        assertThat(expected.getName().equals(labelText)).isTrue();
    }
}
