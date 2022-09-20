package com.EasyParking.O18_14.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EasyParking.O18_14.model.Parqueadero;


//@Repository
public interface ParqueaderoDao extends CrudRepository<Parqueadero,Integer> {

}
