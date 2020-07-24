package com.sakk.mydemo.sboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sakk.mydemo.sboot.entity.Player;
import com.sakk.mydemo.sboot.entity.Team;
import com.sakk.mydemo.sboot.util.CommonConstant;
import com.sakk.mydemo.sboot.util.CommonUtil;

public class TeamDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String foundedYear;

	private int totalMatches;

	private List<PlayerDTO> players;

	public TeamDTO() {
		super();
		this.id = 0;
		this.name = "";
		this.foundedYear = "";
		this.totalMatches = 0;
		this.players = new ArrayList<>();
	}

	public TeamDTO(Team team) {
		if (team != null) {
			this.id = team.getId();
			this.name = team.getTeamname();
			this.foundedYear = CommonUtil.changeDateToString(CommonConstant.STD_DATE_FORMAT, team.getFoundedYear());
			this.totalMatches = team.getTotalMatches();
			this.players = new ArrayList<>();
			if (team.getPlayers() != null) {
				for (Player player : team.getPlayers()) {
					this.players.add(new PlayerDTO(player));
				}
			}
		}
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(String foundedYear) {
		this.foundedYear = foundedYear;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}

}
