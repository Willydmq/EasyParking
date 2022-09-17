package com.EasyParking.O18_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EasyParking.O18_14.model.Parqueadero;
import com.EasyParking.O18_14.model.User;

import org.springframework.data.domain.Sort;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
	
	public List<Parqueadero> findByUser(User user, Sort sort);
	
	public Parqueadero findByUserAndId(User user, Integer id);

}
