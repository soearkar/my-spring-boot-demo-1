package com.sakk.mydemo.sboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.mydemo.sboot.entity.Product;
import com.sakk.mydemo.sboot.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController extends MainController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/list")
	public List<Product> getList(HttpServletRequest request) {
		return productService.getList();
	}

}
