package com.sakk.mydemo.sboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.mydemo.sboot.model.LoginDTO;
import com.sakk.mydemo.sboot.model.UserDTO;
import com.sakk.mydemo.sboot.service.LoginService;
import com.sakk.mydemo.sboot.util.ApiResponse;
import com.sakk.mydemo.sboot.util.CommonConstant.LoginStatus;

@RestController
@RequestMapping("/v1/auth")
public class LoginController extends MainController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "/login")
	public ApiResponse login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
		UserDTO userDTO = loginService.login(loginDTO.getEmail(), loginDTO.getPassword());
		int statusCode = (userDTO != null)? LoginStatus.SUCCESS.getCode() : LoginStatus.FAIL.getCode();
		String statusDesc = (userDTO != null)? LoginStatus.SUCCESS.getDesc() : LoginStatus.FAIL.getDesc() ;
		ApiResponse response = new ApiResponse();
        response.setStatusCode(statusCode);
        response.setStatusDescription(statusDesc);
        response.setData(userDTO == null ? "": userDTO);
		return response;
	}


}
