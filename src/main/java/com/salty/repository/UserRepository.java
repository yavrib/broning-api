package com.salty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salty.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
