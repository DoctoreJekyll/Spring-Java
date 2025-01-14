package edu.shop.demo.demoshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handledBadRequest(RuntimeException ex, WebRequest request)
    {
        Map<String,Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("message", ex.getMessage());
        body.put("Error", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
