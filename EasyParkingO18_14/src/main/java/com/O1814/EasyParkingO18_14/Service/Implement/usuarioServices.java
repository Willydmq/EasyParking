package com.O1814.EasyParkingO18_14.Service.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.O1814.EasyParkingO18_14.Dao.IUsuario;
import com.O1814.EasyParkingO18_14.Models.usuario;
import com.O1814.EasyParkingO18_14.Service.IusuarioServices;

@Service
public class usuarioServices implements IusuarioServices {

	@Autowired
	private IUsuario data;

	@Override
	public List<usuario> findAll() {
		return(List<usuario>) data.findAll();
	}

	@Override
	public usuario findById(String codigo_usu) {
		return data.findById(codigo_usu).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public usuario save(usuario usuario) {
		return data.save(usuario);
	}

	@Override
	public void delete(String codigo_usu) {
		data.deleteById(codigo_usu);
		
	}
	

}