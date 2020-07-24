package com.sakk.mydemo.sboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakk.mydemo.sboot.dao.ProductDao;
import com.sakk.mydemo.sboot.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	public List<Product> getList() {
		return productDao.findAll();
	}

}
