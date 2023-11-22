package com.rodriguezlazo.tasksmanager.controllers;

import com.rodriguezlazo.tasksmanager.dtos.NewCategoryDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.Project;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.services.ProjectService;
import com.rodriguezlazo.tasksmanager.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<Project> projects =(List<Project>) projectService.findAll();
            return new ResponseEntity<>(
                    projects,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> registerProject(@Valid @RequestBody NewProjectDTO projectDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            User foundUser = userService.findOneByUsername(projectDTO.getUsername());
            if(foundUser ==null){
                return new ResponseEntity<>("El usuario para el proyecto no existe", HttpStatus.BAD_REQUEST);
            }

            //userService.save();
            projectService.saveProject(projectDTO,foundUser);
            return new ResponseEntity<>(
                    "Proyecto registrado",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }


}
