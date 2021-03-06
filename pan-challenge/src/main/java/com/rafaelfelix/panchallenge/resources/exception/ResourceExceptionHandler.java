package com.rafaelfelix.panchallenge.resources.exception;

import java.net.UnknownHostException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import com.rafaelfelix.panchallenge.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<?> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
        	   .body(new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date()));
    }
	
	@ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<?> httpServerError(HttpServerErrorException exception) {
		return ResponseEntity.badRequest()
        	   .body(new StandardError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), new Date()));
    }
	
	@ExceptionHandler(UnknownHostException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<?> unknownHost(UnknownHostException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        	   .body(new StandardError(HttpStatus.NOT_FOUND.value(), "URL não encontrada: ".concat(exception.getMessage()), new Date()));
    }
}
