package com.sakk.mydemo.sboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakk.mydemo.sboot.entity.User;

@Repository
public interface LoginDao extends JpaRepository<User,Long> {
	User findByEmail(String email);
}
