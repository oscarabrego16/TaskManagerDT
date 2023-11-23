package com.rodriguezlazo.tasksmanager.services;


import com.rodriguezlazo.tasksmanager.dtos.NewCommentDTO;
import com.rodriguezlazo.tasksmanager.entities.Comment;
import com.rodriguezlazo.tasksmanager.entities.Task;

public interface CommentService extends GenericService<Comment, NewCommentDTO> {
    Comment saveComment(NewCommentDTO dto, Task task);
}
