package com.daniel.doctorappbackend.user.advice;

import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler({UserNotFoundException.class, UserExistException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleUserNotFound(UserNotFoundException userNotFoundException){
        return userNotFoundException.getMessage();
    }

    /*
    @ResponseStatus(value = HttpStatus.FOUND)
    public String handleUserExist(UserExistException userExistException){
        return userExistException.getMessage();
    }*/
}
