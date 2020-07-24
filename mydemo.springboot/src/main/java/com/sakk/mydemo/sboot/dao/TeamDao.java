package com.sakk.mydemo.sboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.mydemo.sboot.entity.Team;

public interface TeamDao extends JpaRepository<Team, Long> {
	Team findById(long id);
}
