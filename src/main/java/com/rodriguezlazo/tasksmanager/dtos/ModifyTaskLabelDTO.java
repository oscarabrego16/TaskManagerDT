package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModifyTaskLabelDTO {
    @NotNull
    private Long label_id;
    @NotNull
    @Size(min = 3)
    private String name;

    public ModifyTaskLabelDTO() {
    }

    public Long getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Long label_id) {
        this.label_id = label_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
