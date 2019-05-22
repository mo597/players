package com.fr.adaming.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IDaoUser;
import com.fr.adaming.entities.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IDaoUser daoUser;
	
	//Définition d'un variable logger référence à l'instance Logger
	Logger logger = Logger.getLogger(UserService.class);

	@Override
	public User create(User user) {
		try {
		if(user.getId()==null||user.getId()==0) {
		daoUser.save(user);
			System.out.println("User créé");
			return user;
		}else {daoUser.findById(user.getId());
				System.out.println("User existe déjà");
				return user;
		}
		//Insérer des if et else pour passer de create à updater si user existant
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			logger.warn("L'id ou le user ne doit pas être nul");
			return null;
		}
		}

	@Override
	public User readByEmail(String email, String pwd) {
		return daoUser.findByEmail(email, pwd);
		
	}

	@Override
	public List<User> readAll() {
		return daoUser.findAll();
	}

	@Override
	public boolean delete(User user) {
		try {
		daoUser.delete(user);
		return true;
		}catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			logger.warn("Merci de renseigner un user" + iae);
		}
		return false;
	}

	@Override
	public void update(User user) {
		
		
	}


}
