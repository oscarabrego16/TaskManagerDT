package com.rodriguezlazo.tasksmanager.controllers;

import com.rodriguezlazo.tasksmanager.dtos.NewTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.entities.TaskLabel;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasklabel")
public class TaskLabelController
{
    @Autowired
    private TaskLabelService taskLabelService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<TaskLabel> taskLabels =(List<TaskLabel>) taskLabelService.findAll();
            return new ResponseEntity<>(
                    taskLabels,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerTaskLabel(@Valid @RequestBody NewTaskLabelDTO taskLabelDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            TaskLabel foundLabel = taskLabelService.findOneByName(taskLabelDTO.getName());
            if(foundLabel !=null){
                return new ResponseEntity<>("Esta categoria ya existe", HttpStatus.BAD_REQUEST);
            }

            //userService.save();
            taskLabelService.save(taskLabelDTO);
            return new ResponseEntity<>(
                    "TaskLabel registrada",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

}
