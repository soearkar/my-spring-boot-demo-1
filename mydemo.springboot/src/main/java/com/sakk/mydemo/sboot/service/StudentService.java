package com.sakk.mydemo.sboot.service;

import java.util.List;

import com.sakk.mydemo.sboot.entity.Student;
import com.sakk.mydemo.sboot.model.StudentDTO;

public interface StudentService {
	public List<Student> getList();
	
	public StudentDTO findStudentById(long id);
	
	public StudentDTO saveStudent(StudentDTO studentDTO);
		
	public boolean deleteStudent(long id); 
}
