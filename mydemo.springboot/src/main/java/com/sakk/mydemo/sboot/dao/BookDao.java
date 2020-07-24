package com.sakk.mydemo.sboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.mydemo.sboot.entity.Book;

public interface BookDao extends JpaRepository<Book, Long> {

}
