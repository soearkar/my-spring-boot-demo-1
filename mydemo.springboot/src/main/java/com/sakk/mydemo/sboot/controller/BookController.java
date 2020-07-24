package com.sakk.mydemo.sboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.mydemo.sboot.model.BookDTO;
import com.sakk.mydemo.sboot.service.BookService;
import com.sakk.mydemo.sboot.util.ApiResponse;
import com.sakk.mydemo.sboot.util.CommonConstant.MessageStatus;

@RestController
@RequestMapping("/v1/book")
public class BookController extends MainController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value = "/save")
	public ApiResponse save(@RequestBody BookDTO bookDTO, HttpServletRequest request) {
		BookDTO savedBook =  bookService.saveBook(bookDTO);
		int statusCode = (savedBook != null)? MessageStatus.SUCCESS.getCode() : MessageStatus.FAIL.getCode();
		String statusDesc = (savedBook != null)? MessageStatus.SUCCESS.getDesc() : MessageStatus.FAIL.getDesc() ;
		ApiResponse response = new ApiResponse();
        response.setStatusCode(statusCode);
        response.setStatusDescription(statusDesc);
        response.setData(savedBook == null ? "": savedBook);
		return response;
	}
}
