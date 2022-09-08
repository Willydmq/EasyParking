
package com.O1814.EasyParkingO18_14.Dao;


import com.O1814.EasyParkingO18_14.Models.parqueadero;
import org.springframework.data.repository.CrudRepository;
import org-springframework.stereotype.Repository;


@Repository
public interface parqueaderoDao extends CrudRepository<parqueadero, String> {
}



