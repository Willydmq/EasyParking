package com.O1814.EasyParkingO18_14.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.O1814.EasyParkingO18_14.Models.usuario;
import com.O1814.EasyParkingO18_14.Service.IusuarioServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/parqueadero")
public class Controlador{

	@Autowired
	private parqueaderoServices service;

	@GetMapping("/")
	public List<parqueadero> consultAll(){
        return service.findAll();
    }

	@GetMapping("/{nit}")
	public parqueadero consultById(@PathVariable String nit){
        return service.findById(nit);
    }

	@PostMapping("/")
	public ResponseEntity<parqueadero> add(@RequestBody parqueadero parqueadero) {
		parqueadero record = service.save(parqueadero);
		
		
		return new ResponseEntity<>(record, HttpStatus.OK);
	}
	
	@DeleteMapping("/{nit}")
    public ResponseEntity<parqueadero> delete(@PathVariable String nit){
        parqueadero foundRecord = service.findById(nit);
        if (foundRecord != null){
            service.delete(nit);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<parqueadero> update(@RequestBody parqueadero parqueadero){
        parqueadero foundRecord = service.findById(parqueadero.getnit());
        if(foundRecord!=null){
            foundRecord.setrazon_social(parqueadero.getrazon_social());
            service.save(parqueadero);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }

}
