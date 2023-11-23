package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.NewCommentDTO;
import com.rodriguezlazo.tasksmanager.entities.Comment;
import com.rodriguezlazo.tasksmanager.entities.Task;
import com.rodriguezlazo.tasksmanager.repositories.CommentRepository;
import com.rodriguezlazo.tasksmanager.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository repository;

    @Override
    public Comment saveComment(NewCommentDTO dto, Task task) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setTimestamp(dto.getTimestamp());
        comment.setTask(task);
        return repository.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Comment save(NewCommentDTO dto) {
        return null;
    }

    @Override
    public Iterable<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
