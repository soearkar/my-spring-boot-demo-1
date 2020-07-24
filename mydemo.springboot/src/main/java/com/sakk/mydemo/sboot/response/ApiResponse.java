package com.sakk.mydemo.sboot.response;

public class ApiResponse<T> {

	private String responseCode;
	private String responseMessage;
	private T data;
	
	public ApiResponse() {
		super();
	}
	

	public ApiResponse(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public ApiResponse(String responseCode, String responseMessage, T data) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.data = data;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
