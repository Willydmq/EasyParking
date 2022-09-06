package com.O1814.EasyParkingO18_14.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.O1814.EasyParkingO18_14.Models.usuario;


@Repository
public interface IUsuario extends CrudRepository<usuario, String> {
    
}
