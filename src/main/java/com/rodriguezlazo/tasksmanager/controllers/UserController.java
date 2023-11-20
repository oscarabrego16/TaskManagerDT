package com.rodriguezlazo.tasksmanager.controllers;


import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
