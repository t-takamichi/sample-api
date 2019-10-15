package com.example.applictiontraning.advice;

import com.example.applictiontraning.exception.BadRequestException;
import com.example.applictiontraning.exception.DataNotFoundException;
import com.example.applictiontraning.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> dataNoFound(Exception e){
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode("404")
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequest(Exception e){
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode("400")
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> system(Exception e){
        System.out.println(e.getMessage());
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode("500")
                .description("SYSTEM ERROR")
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
