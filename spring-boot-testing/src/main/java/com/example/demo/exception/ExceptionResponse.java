package com.example.demo.exception;

import java.util.List;

public class ExceptionResponse {
private String msg;
private String details;
public ExceptionResponse(String msg, String details) {
    super();
    this.msg = msg;
    this.details = details;
  }

  public ExceptionResponse(List<String> msg, String details) {
	    super();
	    this.msg = msg.toString();
	    this.details = details;
	  }
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
}
