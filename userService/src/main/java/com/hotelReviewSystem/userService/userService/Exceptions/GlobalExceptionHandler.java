package com.hotelReviewSystem.userService.userService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*Anywhere in project exception occurs we can it globally here with the use of this @RestControllerAdvice annotation*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        String msg=ex.getMessage();
        ApiResponce rspc= ApiResponce.builder()
                .message(msg)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(rspc,HttpStatus.NOT_FOUND);
    }


}
