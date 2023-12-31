package com.rodriguezlazo.tasksmanager.controllers;

import com.rodriguezlazo.tasksmanager.dtos.ModifyTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.dtos.ModifyUserDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewTaskLabelDTO;
import com.rodriguezlazo.tasksmanager.entities.Task;
import com.rodriguezlazo.tasksmanager.entities.TaskLabel;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?
            > registerTaskLabel(@Valid @RequestBody NewTaskLabelDTO taskLabelDTO, BindingResult bindingResult){
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskLabelById(@PathVariable(name = "id") Long id){
        try {
            Optional<TaskLabel> foundTaskLabel = taskLabelService.findById(id);
            if (foundTaskLabel.isEmpty()){
                return new ResponseEntity<>("Label no encontrada", HttpStatus.NOT_FOUND);
            }
            taskLabelService.deleteById(foundTaskLabel.get().getLabel_id());
            return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyTaskLabelById(@Valid @RequestBody ModifyTaskLabelDTO labelInfo, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }

            Optional<TaskLabel> foundTaskLabel = taskLabelService.findById(labelInfo.getLabel_id()); //implementar el id en un nuevo dto
            if (foundTaskLabel.isEmpty()){
                return new ResponseEntity<>("Label no encontrado", HttpStatus.NOT_FOUND);
            }
            TaskLabel foundLabel2 = taskLabelService.findOneByName(labelInfo.getName()); //implementar el id en un nuevo dto
            if(foundLabel2 !=null){
                return new ResponseEntity<>("Nombre de de label ya registrado", HttpStatus.CONFLICT);
            }

            taskLabelService.modifyById(labelInfo);
            return new ResponseEntity<>("Modificado con exito", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
