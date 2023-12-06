package com.rodriguezlazo.tasksmanager.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasklabel")
public class TaskLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long label_id;
    private String name;
    @OneToMany(mappedBy = "taskLabel", fetch = FetchType.LAZY)
    private List<Task>tasks;

    public TaskLabel(String name) {
        this.name = name;
    }

    public TaskLabel() {

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
