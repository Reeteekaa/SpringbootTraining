package com.trg.jpa.data;

import java.time.LocalDateTime;

public class ResponseMessage {
	
	private String message;
	private LocalDateTime timstamp;
	public ResponseMessage(String message, LocalDateTime timstamp) {
		super();
		this.message = message;
		this.timstamp = timstamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimstamp() {
		return timstamp;
	}
	public void setTimstamp(LocalDateTime timstamp) {
		this.timstamp = timstamp;
	}
	
	

}
