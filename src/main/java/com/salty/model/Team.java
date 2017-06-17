package com.salty.model;

import java.util.ArrayList;

public class Team {
	Long id;
	String name;
	ArrayList<User> members;
	Game field;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	public Game getField() {
		return field;
	}
	public void setField(Game field) {
		this.field = field;
	}
	
}
