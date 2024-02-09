package com.trg.jpa.exceptions;

public class MissingDataException extends RuntimeException {
	
	public String getMessage() {
		return "Employee data does not exist";
	}
	

}
