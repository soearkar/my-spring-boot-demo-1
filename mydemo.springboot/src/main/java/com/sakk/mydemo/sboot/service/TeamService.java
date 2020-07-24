package com.sakk.mydemo.sboot.service;

import java.util.List;

import com.sakk.mydemo.sboot.model.TeamDTO;

public interface TeamService {
	public List<TeamDTO> getList();
	
	public TeamDTO findTeamById(long id);
	
	public TeamDTO saveTeam(TeamDTO teamDTO);
	
	public boolean deleteTeam(long id);

}
