package com.rodriguezlazo.tasksmanager.controllers;


import com.rodriguezlazo.tasksmanager.dtos.NewAttachmentDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewProjectDTO;
import com.rodriguezlazo.tasksmanager.entities.Attachment;
import com.rodriguezlazo.tasksmanager.entities.Comment;
import com.rodriguezlazo.tasksmanager.entities.Task;
import com.rodriguezlazo.tasksmanager.services.AttachmentService;
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
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<Attachment> attachments =(List<Attachment>) attachmentService.findAll();
            return new ResponseEntity<>(
                    attachments,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerAttachment(@Valid @RequestBody NewAttachmentDTO attachmentDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            Task foundTask = taskService.findById(Long.valueOf(attachmentDTO.getTask_id())).get();
            if(foundTask ==null){
                return new ResponseEntity<>("La tarea para este archivo no existe", HttpStatus.BAD_REQUEST);
            }

            attachmentService.saveAttachment(attachmentDTO,foundTask);
            return new ResponseEntity<>(
                    "Archivo agregado a la tarea",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAttachmentById(@PathVariable(name = "id") Long id){
        try {
            Optional<Attachment> foundAttachment = attachmentService.findById(id);
            if (foundAttachment.isEmpty()){
                return new ResponseEntity<>("Adjunto no encontrado", HttpStatus.NOT_FOUND);
            }
            attachmentService.deleteById(foundAttachment.get().getId());
            return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

}
