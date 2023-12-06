package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.TaskLabel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void findCategoryByUsername() {
        String categoryText= "UCA";
//given
        Category category= new Category(categoryText);
        categoryRepository.save(category);

//when

        Category expected =categoryRepository.findCategoryByName(categoryText);
        System.out.println(expected.toString());
//then
        assertThat(expected.getName().equals(categoryText)).isTrue();
    }

}
