
package com.O1814.EasyParkingO18_14.Service.Implement;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.O1814.EasyParkingO18_14.Dao.IUsuario;
import com.O1814.EasyParkingO18_14.Models.usuario;
import com.O1814.EasyParkingO18_14.Service.IusuarioServices;

@Service
public class parqueaderoServices implements parqueaderoServices {
	
	@Autowired
	private parqueadero data;

	@Override
	public List<parqueadero> findAll() {
		return(List<parqueadero>) data.findAll();
	}

	@Override
	public parqueadero findById(String nit) {
		return data.findById(nit).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public parqueadero save(parqueadero parqueadero) {
		return data.save(parqueadero);
	}

	@Override
	public void delete(String nit) {
		data.deleteById(nit);
		
	}
	
}