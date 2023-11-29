package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    void findUserByUsername() {
//given
        User user01= new User("OscarTest", "RodriguezTest", "oscarrodtest", "Passstest");
        userRepository.save(user01);

//when
        String username= "oscarrodtest";
        User expected =userRepository.findUserByUsername(username);
        System.out.println(expected.toString());
//then
        assertThat(expected.getUsername().equals(username)).isTrue();
    }
}