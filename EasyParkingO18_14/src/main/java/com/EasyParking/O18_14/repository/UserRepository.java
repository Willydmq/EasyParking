package com.EasyParking.O18_14.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EasyParking.O18_14.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
