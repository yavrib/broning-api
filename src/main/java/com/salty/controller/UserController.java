package com.salty.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salty.model.User;
import com.salty.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private UserRepository userRepository;
	
	@Autowired
	public UserRepository getUserRepository() {
		return this.userRepository;
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return getUserRepository().findAll();
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return getUserRepository().saveAndFlush(user);		
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User getUser(Long id) {
		return getUserRepository().findOne(id);		
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT) 
	public User update(@PathVariable Long id, @RequestBody User user) {
		User existingUser = getUserRepository().findOne(id);
		BeanUtils.copyProperties(user, existingUser);
		return getUserRepository().saveAndFlush(existingUser);
	}
}
