package com.EasyParking.O18_14.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyParking.O18_14.model.User;
import com.EasyParking.O18_14.repository.UserRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public ResponseEntity<Map<String, String>> saveUser(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
                Map<String, String> response  = new  HashMap<String, String>();
                response.put("message", "Unauthorized user");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<Map<String, String>> login (@RequestBody User user) {
		User userFound = userRepository.findByUsername(user.getUsername());
		Map<String, String> response  = new  HashMap<String, String>();
		
		if(userFound == null) {
			response.put("message", "Unauthorized user");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}

		if(bCryptPasswordEncoder.matches(user.getPassword(), userFound.getPassword())){
			response.put("message", "Login user successfull");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}else {
			response.put("message", "Unauthorized user");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
		
		
	}

}
