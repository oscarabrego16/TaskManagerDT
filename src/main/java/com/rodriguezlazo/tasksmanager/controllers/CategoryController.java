package com.rodriguezlazo.tasksmanager.controllers;

import com.rodriguezlazo.tasksmanager.dtos.NewCategoryDTO;
import com.rodriguezlazo.tasksmanager.dtos.NewUserDTO;
import com.rodriguezlazo.tasksmanager.entities.Category;
import com.rodriguezlazo.tasksmanager.entities.User;
import com.rodriguezlazo.tasksmanager.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try {
            List<Category> categories =(List<Category>) categoryService.findAll();
            return new ResponseEntity<>(
                    categories,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerCategory(@Valid @RequestBody NewCategoryDTO categoryDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String errors = bindingResult.getAllErrors().toString();
                return new ResponseEntity<>("Errores en validacion: "+ errors, HttpStatus.BAD_REQUEST);
            }
            Category foundCategory = categoryService.findOneByName(categoryDTO.getName());
            if(foundCategory !=null){
                return new ResponseEntity<>("Esta categoria ya existe", HttpStatus.BAD_REQUEST);
            }

            //userService.save();
            categoryService.save(categoryDTO);
            return new ResponseEntity<>(
                    "Categoria registrada",
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable(name = "id") Long id){
        try {
            Optional<Category> foundCategory = categoryService.findById(id);
            if (foundCategory.isEmpty()){
                return new ResponseEntity<>("Categoria no encontrada", HttpStatus.NOT_FOUND);
            }
            categoryService.deleteById(foundCategory.get().getCategory_id());
            return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(
                    "Error interno", HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }
}
