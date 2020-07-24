package com.sakk.mydemo.sboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4427716349817048428L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "teamname")
	private String teamname;

	@Column(name = "foundedyear")
	private Date foundedYear;

	@Column(name = "totalmatches")
	private int totalMatches;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	
	public Date getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(Date foundedYear) {
		this.foundedYear = foundedYear;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	
}
