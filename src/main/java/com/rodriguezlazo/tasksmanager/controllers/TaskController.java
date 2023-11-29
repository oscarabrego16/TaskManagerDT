package com.rodriguezlazo.tasksmanager.controllers;


import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewTaskDTO;
import com.rodriguezlazo.tasksmanager.entities.*;
import com.rodriguezlazo.tasksmanager.services.CategoryService;
import com.rodriguezlazo.tasksmanager.services.ProjectService;
import com.rodriguezlazo.tasksmanager.services.TaskLabelService;
import com.rodriguezlazo.tasksmanager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskLabelService labelService;



    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<Task> tasks =(List<Task>) taskService.findAll();
            return new ResponseEntity<>(
                    tasks,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> registerTask(@Valid @RequestBody NewTaskDTO taskDTO, BindingResult bindingResult){

        TaskStatus status;

        TaskPriority priority;

        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            Optional<Project> foundProject = projectService.findById(taskDTO.getProject_id());

            if(foundProject.isEmpty()){
                return new ResponseEntity<>("El proyecto para la tarea no existe", HttpStatus.BAD_REQUEST);
            }

            Category foundCategory = categoryService.findOneByName(taskDTO.getCategory());

            if(foundCategory ==null){
                return new ResponseEntity<>("La categoria para la tarea no existe", HttpStatus.BAD_REQUEST);
            }

            TaskLabel foundTaskLabel = labelService.findOneByName(taskDTO.getLabel());

            if(foundTaskLabel ==null){
                return new ResponseEntity<>("La Label no existe", HttpStatus.BAD_REQUEST);
            }

            switch (taskDTO.getStatus()){
                case "TO_DO":
                    status= TaskStatus.valueOf(taskDTO.getStatus());
                    break;
                case "IN_PROGRESS":
                    status= TaskStatus.valueOf(taskDTO.getStatus());
                    break;
                case "DONE":
                    status= TaskStatus.valueOf(taskDTO.getStatus());
                    break;
                default:
                    return new ResponseEntity<>("El status para la tarea no existe", HttpStatus.BAD_REQUEST);

            }
            switch (taskDTO.getPriority()){
                case "LOW":
                    priority= TaskPriority.valueOf(taskDTO.getPriority());
                    break;
                case "HiGH":
                    priority= TaskPriority.valueOf(taskDTO.getPriority());
                    break;
                case "MEDIUM":
                    priority= TaskPriority.valueOf(taskDTO.getPriority());
                    break;
                default:
                    return new ResponseEntity<>("La prioridad para la tarea no existe", HttpStatus.BAD_REQUEST);
            }

            if(status ==null){
                return new ResponseEntity<>("El status no existe", HttpStatus.BAD_REQUEST);
            }
            if(priority ==null){
                return new ResponseEntity<>("La prioridad no existe", HttpStatus.BAD_REQUEST);
            }

            //userService.save();
            taskService.saveTask(taskDTO, foundProject.get(), foundCategory, status, foundTaskLabel , priority);
            return new ResponseEntity<>(
                    "Tarea registrada",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

}
