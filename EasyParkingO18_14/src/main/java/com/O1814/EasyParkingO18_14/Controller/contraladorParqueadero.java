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

import com.O1814.EasyParkingO18_14.Models.parqueadero;
import com.O1814.EasyParkingO18_14.Models.usuario;
import com.O1814.EasyParkingO18_14.Service.IusuarioServices;
import com.O1814.EasyParkingO18_14.Service.parqueaderoServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/parqueadero")
public class contraladorParqueadero {

	@Autowired
	private parqueaderoServices service;

	@GetMapping("/list")
	public List<parqueadero> consultAll(){
        return service.findAll();
    }

	@GetMapping("/view/{nit}")
	public parqueadero consultById(@PathVariable String nit){
        return service.findById(nit);
    }

	@PostMapping("/add")
	public ResponseEntity<parqueadero> add(@RequestBody parqueadero parqueadero) {
		parqueadero record = service.save(parqueadero);
		return new ResponseEntity<>(record, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{nit}")
    public ResponseEntity<parqueadero> delete(@PathVariable String nit){
        parqueadero record = service.findById(nit);
        if (record != null){
            service.delete(nit);
        }
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<parqueadero> update(@RequestBody parqueadero parqueadero){
    	parqueadero record = service.findById(parqueadero.getnit());
        if(record!=null){
            record.setrazon_social(parqueadero.getrazon_social());
            service.save(record);
        }
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

}
