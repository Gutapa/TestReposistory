package com.shreeganesh.SpringREST2.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shreeganesh.SpringREST2.api.ErrorResponse;
import com.shreeganesh.SpringREST2.exception.StudentException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentException.class)
	ResponseEntity<ErrorResponse> handleStudentexception(Exception se){
		ErrorResponse er = new ErrorResponse();
		er.setErrordate(new Date());
		er.setErrormessage(se.getMessage()+" Test1 Function");
		er.setErrortype(se.getClass().toString());
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(IOException.class)
	ResponseEntity<ErrorResponse> handleStudentexception2(Exception se){
		ErrorResponse er = new ErrorResponse();
		er.setErrordate(new Date());
		er.setErrormessage(se.getMessage());
		er.setErrortype(se.getClass().toString()+" Test2 Function");
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
}
