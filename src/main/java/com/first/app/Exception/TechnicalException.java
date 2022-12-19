package com.first.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TechnicalException extends RuntimeException {

	//private String message;
	public TechnicalException(String message)
	{
		super(message);
		//this.message=message;
	}
	/*public String getMessage() {
		return message;
	}*/
	
	
}
