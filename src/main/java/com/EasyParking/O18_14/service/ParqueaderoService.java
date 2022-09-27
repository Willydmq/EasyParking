package com.EasyParking.O18_14.service;

import java.util.List;

import com.EasyParking.O18_14.model.Parqueadero;

public interface ParqueaderoService {
	
	public Parqueadero save(Parqueadero parqueadero);

    public void delete(Integer id);

    public Parqueadero findById(Integer id);

    public List<Parqueadero> findAll();

}
