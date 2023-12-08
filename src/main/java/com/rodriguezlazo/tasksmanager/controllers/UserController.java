package com.rodriguezlazo.tasksmanager.controllers;


import com.rodriguezlazo.tasksmanager.dtos.ModifyUserDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@Valid @RequestBody NewUserDTO userinfo, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            User foundUser = userService.findOneByUsername(userinfo.getUsername());
            if(foundUser !=null){
                return new ResponseEntity<>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
            }

            //userService.save();
            userService.save(userinfo);
            return new ResponseEntity<>(
                    "Persona registrada",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<User> users =(List<User>) userService.findAll();
            return new ResponseEntity<>(
                    users,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "id") Long id){
        try {
            Optional<User> foundUser = userService.findById(id);
            if (foundUser.isEmpty()){
                return new ResponseEntity<>("Area no encontrada", HttpStatus.NOT_FOUND);
            }
            userService.deleteById(foundUser.get().getId());
            return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyUserById(@Valid @RequestBody ModifyUserDTO userinfo, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }

            Optional<User> foundUser = userService.findById(userinfo.getId()); //implementar el id en un nuevo dto
            if (foundUser.isEmpty()){
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
            User foundUser2 = userService.findOneByUsername(userinfo.getUsername()); //implementar el id en un nuevo dto
            if(foundUser2 !=null){
                return new ResponseEntity<>("Nombre de usuario registrado", HttpStatus.CONFLICT);
            }

            userService.modifyUserById(userinfo);
            return new ResponseEntity<>("Modificado con exito", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
