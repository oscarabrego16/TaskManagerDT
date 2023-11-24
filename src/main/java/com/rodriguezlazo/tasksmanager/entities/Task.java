package com.rodriguezlazo.tasksmanager.entities;


import jakarta.persistence.*;

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
    private Project project;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY ,cascade =CascadeType.ALL)
    private List<Attachment> attachments;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    private List<Comment> comments;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="label_id")
    private TaskLabel taskLabel;
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category taskCategory;



}
