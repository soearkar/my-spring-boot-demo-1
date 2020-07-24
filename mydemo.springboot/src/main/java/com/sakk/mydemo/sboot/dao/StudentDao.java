package com.sakk.mydemo.sboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.mydemo.sboot.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
	Student findByEmail(String email);
}
