package com.rodriguezlazo.tasksmanager.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "taskPriority")
public class TaskPriority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priority_id;
    private String name;
    @OneToMany(mappedBy = "taskPriority", fetch = FetchType.LAZY)
    private List<Task> tasks;

    public TaskPriority(String name) {
        this.name = name;
    }

    public TaskPriority() {

    }

    public Long getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(Long priority_id) {
        this.priority_id = priority_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
