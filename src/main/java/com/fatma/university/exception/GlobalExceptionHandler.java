package com.fatma.university.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> RecordNotFoundException(RecordNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> DuplicateRecordException(DuplicateRecordException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
    @ExceptionHandler(RecordNotCorrectException.class)
    public ResponseEntity<?> DuplicateRecordException(RecordNotCorrectException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }


    @ExceptionHandler
    public ResponseEntity<?> handelException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }



}
