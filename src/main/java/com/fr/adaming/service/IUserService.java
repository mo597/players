package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entities.User;

public interface IUserService {

	public User create(User user);
	
	public User readByEmail(String email, String pwd);
	
	public List<User> readAll();
	
	public void update(User user);

	public boolean delete(User user);
		
	
}
