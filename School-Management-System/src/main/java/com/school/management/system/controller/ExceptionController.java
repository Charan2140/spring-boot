package com.school.management.system.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.school.management.system.exception.ClassIdNotFoundException;
import com.school.management.system.model.ErrorResponse;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = ClassIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(ClassIdNotFoundException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date()), HttpStatus.NOT_FOUND);
	   }
	}