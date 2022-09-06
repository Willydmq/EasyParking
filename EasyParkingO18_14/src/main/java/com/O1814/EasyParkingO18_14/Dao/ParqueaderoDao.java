package com.O1814.EasyParkingO18_14.Dao;

import com.O1814.EasyParkingO18_14.Models.Parqueadero;
import com.O1814.EasyParkingO18_14.Models.usuario;
import org.springframework.data.repository.CrudRepository;

public interface ParqueaderoDao extends CrudRepository<Parqueadero,String> {
    
}
