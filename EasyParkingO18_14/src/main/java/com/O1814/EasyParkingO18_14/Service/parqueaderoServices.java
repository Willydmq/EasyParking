package com.O1814.EasyParkingO18_14.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.O1814.EasyParkingO18_14.Dao.IUsuario;
import com.O1814.EasyParkingO18_14.Models.usuario;
import com.O1814.EasyParkingO18_14.Service.IusuarioServices;

@Repository

public interface parqueaderoServices {
public List<parqueadero> findAll();

public parqueadero findById(String nit);

public parqueadero save(parqueadero parqueadero);

public void delete(String nit);
	}

