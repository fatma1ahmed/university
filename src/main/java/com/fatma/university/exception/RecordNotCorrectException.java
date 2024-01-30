package com.fatma.university.exception;

public class RecordNotCorrectException extends RuntimeException{
    public RecordNotCorrectException() {
        super();
    }

    public RecordNotCorrectException(String message) {
        super(message);
    }
}
