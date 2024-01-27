package com.school.management.system.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;
	
    private int statusCode;
    private String message;
    
//    public ErrorResponse() {
//    	timeStamp = new Date();
//    }
 
    public ErrorResponse(int httpsCode, String message, Date timeStamp)
    {
        super();
        this.timeStamp = new Date();
        this.statusCode = httpsCode;
        this.message = message;
    }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
  
}
