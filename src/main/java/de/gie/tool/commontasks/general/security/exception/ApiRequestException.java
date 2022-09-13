package de.gie.tool.commontasks.general.security.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException{

    HttpStatus status;

    public ApiRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }


}
