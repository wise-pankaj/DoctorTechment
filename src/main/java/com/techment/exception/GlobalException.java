package com.techment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = PatientNotFound.class)
	public ResponseEntity<String> NoPatient(PatientNotFound exception)
	{
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NotFound.class)
	public ResponseEntity<String> NoPatient(NotFound exception)
	{
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = AlreadyExist.class)
	public ResponseEntity<String> AlreadyExist(AlreadyExist exception)
	{
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.CONFLICT);
	}
	
}
