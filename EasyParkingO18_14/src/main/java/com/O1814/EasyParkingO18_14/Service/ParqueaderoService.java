
package com.O1814.EasyParkingO18_14.Service;

import com.O1814.EasyParkingO18_14.Models.Parqueadero;
import java.util.List;

public interface ParqueaderoService {
    
    public Parqueadero save(Parqueadero parqueadero);
    public void delete(String id);
    public Parqueadero findById(String id);
    public List<Parqueadero> findByAll();
    
    
}
