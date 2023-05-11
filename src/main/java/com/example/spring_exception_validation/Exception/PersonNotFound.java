package com.example.spring_exception_validation.Exception;

public class PersonNotFound extends RuntimeException{
    public PersonNotFound(String message) {
        super(message);
    }

    public PersonNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFound(Throwable cause) {
        super(cause);
    }
}
