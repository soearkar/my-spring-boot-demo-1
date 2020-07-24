package com.sakk.mydemo.sboot.model;

import java.io.Serializable;

import com.sakk.mydemo.sboot.entity.Player;
import com.sakk.mydemo.sboot.util.CommonConstant;
import com.sakk.mydemo.sboot.util.CommonUtil;

public class PlayerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String dob;

	private int totalMatches;
	
	private String address;

	public PlayerDTO() {
		super();
		this.id = 0;
		this.name = "";
		this.totalMatches = 0;
		this.address = "";
	}

	public PlayerDTO(Player player) {
		if (player != null) {
			this.id = player.getId();
			this.name = player.getName();
			this.dob = CommonUtil.changeDateToString(CommonConstant.STD_DATE_FORMAT, player.getDateOfBirth());
			this.totalMatches = player.getTotalMatches();
			this.address = player.getAddress();
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	
}
