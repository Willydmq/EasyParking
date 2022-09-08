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
@RequestMapping("/usuario")
public class Controlador {

	@Autowired
	private IusuarioServices service;

	@GetMapping("/")
	public List<usuario> consultAll(){
        return service.findAll();
    }

	@GetMapping("/{codigo_usu}")
	public usuario consultById(@PathVariable String codigo_usu){
        return service.findById(codigo_usu);
    }

	@PostMapping("/")
	public ResponseEntity<usuario> add(@RequestBody usuario usuario) {
		usuario record = service.save(usuario);
		return new ResponseEntity<>(record, HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo_usu}")
    public ResponseEntity<usuario> delete(@PathVariable String codigo_usu){
        usuario foundRecord = service.findById(codigo_usu);
        if (foundRecord != null){
            service.delete(codigo_usu);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<usuario> update(@RequestBody usuario usuario){
        usuario foundRecord = service.findById(usuario.getCodigo_usu());
        if(foundRecord!=null){
            foundRecord.setNombre_usu(usuario.getNombre_usu());
            service.save(usuario);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }

}
