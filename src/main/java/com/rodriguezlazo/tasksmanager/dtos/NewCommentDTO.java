package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class NewCommentDTO {

    @NotBlank
    private String content;

    @NotBlank
    private Date timestamp;

    @NotBlank
    private int task_id;

    public NewCommentDTO() {
    }

    public NewCommentDTO(String content, Date timestamp, int task_id) {
        this.content = content;
        this.timestamp = timestamp;
        this.task_id = task_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

}
