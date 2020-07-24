package com.sakk.mydemo.sboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.mydemo.sboot.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	Product findByCode(String code);

}
