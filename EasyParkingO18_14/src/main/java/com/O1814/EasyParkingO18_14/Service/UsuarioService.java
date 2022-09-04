
package com.O1814.EasyParkingO18_14.Service;

import com.O1814.EasyParkingO18_14.Models.Usuario;
import java.util.List;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    public void delete(Integer id);
    public Usuario findById(Integer id);
    public List<Usuario> findByAll();
    
    
}
