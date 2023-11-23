package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewTaskLabelDTO {
    @NotBlank
    @Size(min = 3)
    private String name;

    public NewTaskLabelDTO() {
    }

    public NewTaskLabelDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
