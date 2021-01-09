package com.feri.alessandro.attsw.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception) {
		return new ResponseEntity<>("Book not found!", HttpStatus.NOT_FOUND);
	}
}