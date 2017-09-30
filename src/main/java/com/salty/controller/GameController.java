package com.salty.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salty.model.Game;
import com.salty.repository.GameRepository;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {
	private GameRepository gameRepository;
	
	@Autowired
	public GameRepository getGameRepository() {
		return this.gameRepository;
	}
	
	@RequestMapping(value = "games", method = RequestMethod.GET)
	public List<Game> getGames() {
		return getGameRepository().findAll();
	}
	
	@RequestMapping(value = "games", method = RequestMethod.POST)
	public Game createGame(@RequestBody Game game) {
		return getGameRepository().saveAndFlush(game);		
	}
	
	@RequestMapping(value = "games/{id}", method = RequestMethod.GET)
	public Game getGame(Long id) {
		return getGameRepository().findOne(id);
	}
	
	@RequestMapping(value = "games/{id}", method = RequestMethod.PUT) 
	public Game update(@PathVariable Long id, @RequestBody Game game) {
		Game existingGame = getGameRepository().findOne(id);
		BeanUtils.copyProperties(game, existingGame);
		return getGameRepository().saveAndFlush(existingGame);
	}
}
