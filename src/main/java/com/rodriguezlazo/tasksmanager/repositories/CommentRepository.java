package com.rodriguezlazo.tasksmanager.repositories;


import com.rodriguezlazo.tasksmanager.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    //Comment findCommentByTask(Long id);
}
