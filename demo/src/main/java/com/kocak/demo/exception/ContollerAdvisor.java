package com.kocak.demo.exception;

import com.kocak.demo.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ContollerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(Constants.NO_DATA_FOUND_MESSAGE, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        log.error("Unknown Exception: " + ex.getStackTrace());
        return new ResponseEntity<>(Constants.MASTER_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
