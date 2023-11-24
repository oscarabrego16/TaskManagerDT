package com.rodriguezlazo.tasksmanager.controllers;

import com.rodriguezlazo.tasksmanager.dtos.NewCommentDTO;
import com.rodriguezlazo.tasksmanager.entities.Comment;
import com.rodriguezlazo.tasksmanager.entities.Task;
import com.rodriguezlazo.tasksmanager.services.CommentService;
import com.rodriguezlazo.tasksmanager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private TaskService taskService;
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<Comment> comments =(List<Comment>) commentService.findAll();
            return new ResponseEntity<>(
                    comments,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerComment(@Valid @RequestBody NewCommentDTO commentDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            Task foundTask = taskService.findById(Long.valueOf(commentDTO.getTask_id())).get();
            if(foundTask ==null){
                return new ResponseEntity<>("La tarea para este commentario no existe", HttpStatus.BAD_REQUEST);
            }

            commentService.saveComment(commentDTO,foundTask);
            return new ResponseEntity<>(
                    "Commentario agregado a la tarea",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

}
