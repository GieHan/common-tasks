package de.gie.tool.commontasks.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    /*
        1. Create payload containing exception details (ApiException class)
        2. Return response entity
     */
    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(e.getMessage()
                , e.status
                , ZonedDateTime.now(ZoneId.of("Z")));     //Z is UTC

        return new ResponseEntity<>(apiExceptionDTO, e.status);
    };

}
