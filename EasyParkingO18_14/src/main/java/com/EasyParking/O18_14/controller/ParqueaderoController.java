package com.EasyParking.O18_14.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyParking.O18_14.model.Parqueadero;
import com.EasyParking.O18_14.model.User;
import com.EasyParking.O18_14.repository.ParqueaderoRepository;
import com.EasyParking.O18_14.service.UserService;

import org.springframework.data.domain.Sort;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/parqueadero")
public class ParqueaderoController {
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listParqueaderos(Principal principal){
		String nit = principal.getName();
		User currentUser = userService.getUser(nit);
		List<Parqueadero> parqueaderos = parqueaderoRepository.findByUser(currentUser, Sort.by(Sort.Direction.ASC, "createdAt"));
		Map<String, Object> response = new HashMap<>();
		response.put("data", parqueaderos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ResponseEntity<List<Parqueadero>> list(){
		List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();
		return new ResponseEntity<List<Parqueadero>>(parqueaderos,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Map<String, String>> saveParqueadero(@RequestBody Parqueadero parqueadero, Principal principal){
		Map<String, String> response = new HashMap<>();
		String nit = principal.getName();
		User currentUser = userService.getUser(nit);
		if (parqueadero == null) {
			response.put("message", "bad request");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
		if (parqueadero.getNit() == null) {
			response.put("message", "bad request");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
		parqueadero.setUser(currentUser);
		parqueaderoRepository.save(parqueadero);
		response.put("message", "parqueadero created");
		
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
	}

}
