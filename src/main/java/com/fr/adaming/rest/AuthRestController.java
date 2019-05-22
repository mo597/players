package com.fr.adaming.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.UserDto;
import com.fr.adaming.entities.User;
import com.fr.adaming.service.IUserService;

@RestController
@RequestMapping(path = "/api/users")
public class AuthRestController {
	@Autowired
	private IUserService service;
	
	@Valid
	private UserDto dto = new UserDto();
	
	
	@GetMapping
	private User login(@PathVariable String email,@PathVariable String pwd) {
		//UserDto(String name + String firstname)
			return service.readByEmail(dto.getEmail(),dto.getPwd());	
	}

	@PostMapping
	private User register(@RequestBody User user) {
		return service.create(user);
//		return "INSCRIT";
	}
	
	@DeleteMapping
	private void delete(User user) {
	}
	
	@GetMapping(value = "/update" )
	private void update (User user) {
		
	}
}
