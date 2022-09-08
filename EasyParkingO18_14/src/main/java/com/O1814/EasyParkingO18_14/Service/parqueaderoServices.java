package com.O1814.EasyParkingO18_14.Service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.O1814.EasyParkingO18_14.Models.parqueadero;

@Repository

public interface parqueaderoServices {
public List<parqueadero> findAll();

public parqueadero findById(String nit);

public parqueadero save(parqueadero parqueadero);

public void delete(String nit);
	}

