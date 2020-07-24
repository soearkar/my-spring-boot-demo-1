package com.sakk.mydemo.sboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4427716349817048428L;
     @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 
	 @Column(name="Name")
	 private String name;
	 
	 @Column(name="dateofbirth")
	 private Date dateOfBirth;
	  
	 @Column(name="totalmatches")
	 private int totalMatches;
	 
	 @Column(name="address")
	 private String address;
	 
	 @ManyToOne
	 @JoinColumn(name="Team_Id")
	 private Team team;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	
}
