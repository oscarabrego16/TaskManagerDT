package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotBlank;

public class NewAttachmentDTO {
    @NotBlank
    private String file_name;
    @NotBlank
    private String file_type;

    @NotBlank
    private int file_size;

    @NotBlank
    private int task_id;

    public NewAttachmentDTO() {
    }

    public NewAttachmentDTO(String file_name, String file_type, int file_size, int task_id) {
        this.file_name = file_name;
        this.file_type = file_type;
        this.file_size = file_size;
        this.task_id = task_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
}
