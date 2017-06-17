package com.salty.model;

import java.util.Map;

public class User {
	Long id;
	String firstName;
	String lastName;
	String nickname;
	Map<String, String> platformIds;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Map<String, String> getPlatformIds() {
		return platformIds;
	}
	public void setPlatformIds(Map<String, String> platformIds) {
		this.platformIds = platformIds;
	}
	
	
}
