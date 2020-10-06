package com.kocak.demo.exception;

import com.kocak.demo.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ContollerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(Constants.NO_DATA_FOUND_MESSAGE, HttpStatus.ACCEPTED);
    }

}
