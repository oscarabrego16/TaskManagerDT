package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewCategoryDTO {
    @NotBlank
    @Size(min = 3)
    private String name;

    public NewCategoryDTO() {
    }

    public NewCategoryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
