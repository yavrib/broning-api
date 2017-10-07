package com.salty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salty.repository.TeamRepository;
import com.salty.model.Team;
import com.salty.model.User;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {
	private TeamRepository teamRepository;
	
	@Autowired
	public TeamRepository getTeamRepository() {
		return this.teamRepository;
	}
	
	@RequestMapping(value = "teams", method = RequestMethod.GET)
	public List<Team> getTeams() {
		return getTeamRepository().findAll();
	}

	@RequestMapping(value = "teams", method = RequestMethod.POST)
	public Team createTeam(@RequestBody Team team) {
		return getTeamRepository().saveAndFlush(team);		
	}
	
	@RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
	public Team getTeam(Long id) {
		return getTeamRepository().findOne(id);		
	}
	
	@RequestMapping(value = "teams/{id}", method = RequestMethod.PUT) 
	public Team update(@PathVariable Long id, @RequestBody Team team) {
		Team existingTeam = getTeamRepository().findOne(id);
		BeanUtils.copyProperties(team, existingTeam);
		return getTeamRepository().saveAndFlush(existingTeam);
	}
	
	@RequestMapping(value = "teams/{id}", method = RequestMethod.PUT)
	public Team addMember(@PathVariable Long id, @RequestBody User user) {
		Team team = getTeamRepository().findOne(id);
		ArrayList<User> members = team.getMembers();
		if (members.size() < 5) {
			members.add(user);
			team.setMembers(members);
		}
		
		return getTeamRepository().saveAndFlush(team);
	}
	
}
