package com.rodriguezlazo.tasksmanager.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date due_date;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    @JsonIgnore
    private Project project;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY ,cascade =CascadeType.ALL)

    private List<Attachment> attachments;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="label_id")
    @JsonIgnore
    private TaskLabel taskLabel;
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category taskCategory;

    public Task(String title, String description, Date due_date, Project project, TaskLabel taskLabel, TaskPriority taskPriority, TaskStatus taskStatus, Category taskCategory) {
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.project = project;
        this.attachments = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.taskLabel = taskLabel;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskCategory = taskCategory;
    }


    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public TaskLabel getTaskLabel() {
        return taskLabel;
    }

    public void setTaskLabel(TaskLabel taskLabel) {
        this.taskLabel = taskLabel;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Category getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(Category taskCategory) {
        this.taskCategory = taskCategory;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", due_date=" + due_date +
                ", project=" + project +
                ", attachments=" + attachments +
                ", comments=" + comments +
                ", taskLabel=" + taskLabel +
                ", taskPriority=" + taskPriority +
                ", taskStatus=" + taskStatus +
                ", taskCategory=" + taskCategory +
                '}';
    }
}
