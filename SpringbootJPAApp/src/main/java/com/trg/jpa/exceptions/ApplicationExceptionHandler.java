package com.trg.jpa.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trg.jpa.data.ResponseMessage;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(DuplicateDataException.class)
		
	public ResponseEntity<ResponseMessage> handleDuplicateData(RuntimeException ex) {
				ResponseMessage rm = new ResponseMessage(ex.getMessage(), LocalDateTime.now());
				return new ResponseEntity<ResponseMessage>(rm, HttpStatus.BAD_REQUEST);
	}
	//@ExceptionHandler(MissingDataException.class)
		
/*public ResponseEntity<ResponseMessage> handleMissingData(MissingDataException ex) {
		ResponseMessage rm = new ResponseMessage(ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.BAD_REQUEST);
		
	}*/

}
