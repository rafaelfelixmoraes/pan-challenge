package com.rafaelfelix.panchallenge.resources.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rafaelfelix.panchallenge.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<?> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
        	   .body(new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date()));
    }
}
