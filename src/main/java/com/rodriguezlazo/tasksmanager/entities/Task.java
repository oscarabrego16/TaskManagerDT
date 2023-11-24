package com.rodriguezlazo.tasksmanager.entities;


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

    @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="project_id")
    private Project project;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<Attachment> attachments;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<Comment> comments;
    @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="label_id")
    private TaskLabel taskLabel;
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="category_id")
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
}
