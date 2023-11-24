package com.rodriguezlazo.tasksmanager.dtos;

import com.rodriguezlazo.tasksmanager.entities.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class NewTaskDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @Future
    private Date due_date;

    @NotNull
    private Long project_id;


    //private List<Attachment> attachments;
    //private List<Comment> comments;
    @NotBlank
    private String label;
    @NotNull
    private String priority;
    @NotNull
    private String status;
    @NotBlank
    private String category;

    public NewTaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
