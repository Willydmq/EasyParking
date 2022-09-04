
package com.O1814.EasyParkingO18_14.Service.Implement;
import com.O1814.EasyParkingO18_14.Models.Usuario;
import com.O1814.EasyParkingO18_14.Dao.UsuarioDao;
import com.O1814.EasyParkingO18_14.Service.UsuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=false)
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(String id) {
       usuarioDao.deleteById(id);
    }

    @Override
     @Transactional(readOnly=true)
    public Usuario findById(String id) {
        return usuarioDao.findById(id).orElse(null);
      
    }

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findByAll() {
        return (List<Usuario>) usuarioDao.findAll();
       
    }
    
    
}
