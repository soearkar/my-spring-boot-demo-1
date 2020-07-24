package com.sakk.mydemo.sboot.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakk.mydemo.sboot.entity.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3L;

	private long id;

	private String username;

	private String email;
	
	private String phone;
	
	private int status;

    @JsonIgnore
	private String password;

	public UserDTO() {
		super();
		this.id = 0;
		this.username = "";
		this.email = "";
		this.password = "";
		this.status = 1;
	}

	public UserDTO(User user) {
		if (user != null) {
			this.id = user.getId();
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.status = user.getStatus();
			this.phone = user.getPhone();
		}
	}

	public UserDTO convertStudentDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setStatus(user.getStatus());
		}
		return userDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
