package com.example.spring_exception_validation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<PersonException> handlException(PersonNotFound personNotFound)
    {
        PersonException error=new PersonException();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(personNotFound.getMessage());
        error.setTimeStamp(new Date());
        error.setDetails("Entered value not found");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<PersonException> handlexception(Exception e)
    {
        PersonException error=new PersonException();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(new Date());
        error.setDetails("Enter correct value");
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PersonException> handleException(MethodArgumentNotValidException m)
    {
        PersonException error=new PersonException();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Validation Error");
        error.setDetails(m.getBindingResult().getFieldError().getDefaultMessage());
        error.setTimeStamp(new Date());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
