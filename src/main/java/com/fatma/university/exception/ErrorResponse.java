package com.fatma.university.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private String message;
    private boolean success;
    private LocalDateTime dateTime;

    public ErrorResponse() {

    }

    public ErrorResponse(String message) {
        this.success=Boolean.FALSE;
        this.dateTime=LocalDateTime.now();
        this.message = message;
    }
}
