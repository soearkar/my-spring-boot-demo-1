package com.sakk.mydemo.sboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainController {
	
	@GetMapping(value = "/test")
	public String testService(HttpServletRequest request) {
		return "Success";
	}
}
