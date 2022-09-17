package com.O1814.EasyParkingO18_14.Service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.O1814.EasyParkingO18_14.Models.usuario;

@Repository
public interface IusuarioServices {
	public List<usuario> findAll();

    public usuario findById(String codigo_usu);

    public usuario save(usuario usuario);

    public void delete(String codigo_usu);
}
