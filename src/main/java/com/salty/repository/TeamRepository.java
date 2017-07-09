package com.salty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salty.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
