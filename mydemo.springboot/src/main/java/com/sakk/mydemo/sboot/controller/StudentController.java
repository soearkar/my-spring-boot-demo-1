package com.sakk.mydemo.sboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.mydemo.sboot.entity.Student;
import com.sakk.mydemo.sboot.model.StudentDTO;
import com.sakk.mydemo.sboot.service.StudentService;
import com.sakk.mydemo.sboot.util.ApiResponse;
import com.sakk.mydemo.sboot.util.CommonConstant.MessageStatus;

@RestController
@RequestMapping("/v1/student")
public class StudentController extends MainController{
	@Autowired
	StudentService studentService;

	@GetMapping(value = "/list")
	public List<Student> getList(HttpServletRequest request) {
		return studentService.getList();
	}

	@GetMapping(value = "/{id}")
	public StudentDTO getStudent(@PathVariable("id") long id, HttpServletRequest request) {
		return studentService.findStudentById(id);
	}

	@PostMapping(value = "/save")
	public ApiResponse save(@RequestBody StudentDTO studentDTO, HttpServletRequest request) {
		StudentDTO savedStudent = studentService.saveStudent(studentDTO);
		int statusCode = (savedStudent != null)? MessageStatus.SUCCESS.getCode() : MessageStatus.FAIL.getCode();
		String statusDesc = (savedStudent != null)? MessageStatus.SUCCESS.getDesc() : MessageStatus.FAIL.getDesc() ;
		ApiResponse response = new ApiResponse();
        response.setStatusCode(statusCode);
        response.setStatusDescription(statusDesc);
        response.setData(savedStudent == null ? "": savedStudent);
		return response;
	}

	@PostMapping(value = "/delete")
	public ApiResponse delete(@RequestBody Map<String, String> params, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		boolean isSuccess = studentService.deleteStudent(Long.parseLong(params.get("id")));
		int statusCode = (isSuccess)? MessageStatus.SUCCESS.getCode() : MessageStatus.FAIL.getCode();
		String statusDesc = (isSuccess)? MessageStatus.SUCCESS.getDesc() : MessageStatus.FAIL.getDesc() ;
        ApiResponse response = new ApiResponse();
        response.setStatusCode(statusCode);
        response.setStatusDescription(statusDesc);
        response.setData(result);
		return response;
	}


}
