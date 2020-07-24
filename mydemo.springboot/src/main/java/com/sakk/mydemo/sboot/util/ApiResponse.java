package com.sakk.mydemo.sboot.util;

public class ApiResponse {
	private int statusCode;
	private String statusDescription;
	private Object data; 

	public int getStatusCode() {
		return statusCode; 
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
