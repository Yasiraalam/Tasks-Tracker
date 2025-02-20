package com.yasir.tasks.controllers;


import com.yasir.tasks.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Controller
public class GlobalExceptionHandler {


    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleExceptions(
        RuntimeException ex , WebRequest request
    ){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
