package com.salty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salty.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
