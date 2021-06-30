package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.UserService;
import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 30-Jun-21, Wed
 **/
@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }

    /**We have to create global exception handler for validation operations with AOP. All classes
    base is Object so we re returning the Object for error handling  **/
     @ExceptionHandler(MethodArgumentNotValidException.class)
     @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
         Map<String,String> validationErrors = new HashMap<>();
         for (FieldError fieldError:exception.getBindingResult().getFieldErrors()) {
             validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
         }
         ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Errors");
         return errors;

    }




}
