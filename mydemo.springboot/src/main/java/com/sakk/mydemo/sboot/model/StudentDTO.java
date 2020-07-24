package com.sakk.mydemo.sboot.model;

import java.io.Serializable;

import com.sakk.mydemo.sboot.entity.Student;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String email;

	private String address;

	public StudentDTO() {
		super();
		this.id = 0;
		this.name = "";
		this.email = "";
		this.address = "";
	}

	public StudentDTO(Student student) {
		if (student != null) {
			this.id = student.getId();
			this.name = student.getName();
			this.email = student.getEmail();
			this.address = student.getAddress();
		}
	}

	public StudentDTO convertStudentDTO(Student student) {
		StudentDTO studentDTO = null;
		if (student != null) {
			studentDTO = new StudentDTO();
			studentDTO.setId(student.getId());
			studentDTO.setName(student.getName());
			studentDTO.setEmail(student.getEmail());
			studentDTO.setAddress(student.getAddress());
		}
		return studentDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

}
