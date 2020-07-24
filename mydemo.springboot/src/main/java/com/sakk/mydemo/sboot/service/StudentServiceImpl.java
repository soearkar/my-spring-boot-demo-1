package com.sakk.mydemo.sboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakk.mydemo.sboot.dao.StudentDao;
import com.sakk.mydemo.sboot.entity.Student;
import com.sakk.mydemo.sboot.model.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public List<Student> getList() {
		return studentDao.findAll();
	}

	@Override
	public StudentDTO saveStudent(StudentDTO studentDTO) {
		Student student=new Student();
		student.setId(studentDTO.getId());
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setAddress(studentDTO.getAddress());
		return new StudentDTO(studentDao.saveAndFlush(student));
	}

	@Override
	public StudentDTO findStudentById(long id) {
		Optional<Student> student = studentDao.findById(id);
		if(!student.isPresent()){
			return new StudentDTO();
		}
		return new StudentDTO(student.get());
	}

	@Override
	public boolean deleteStudent(long id) {
		try {
			studentDao.deleteById(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
