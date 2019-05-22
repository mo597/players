package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTests {
	
	@Autowired
	private IUserService service;
	
	private User result;
	
	//On crée une classe "miroir" pour réaliser des tests
	//Il existe des tests similaires pour chaque couche mais c'est un autre métier
	//Pour les controllers on ne peut faire de tests avec J-unit puisqu'ils gèrent la relation avec l'extérieur
	//Sans les annotationsn les tests ne peuvent fonctionner
	
	//On appelle les méthodes de la couche Service pour les tester
	//les méthodes assert permettent de réaliser les tests
	//Attention aux types de retours des méthodes !
	@Test
	public void a_createUser() {
		User testUser = new User(null,"nom", "prenom", 15, "momo@yahoo.fr", "null");
		result = service.create(testUser);
		System.out.println("DEBUG : user"+ result.getId());
		assertNotNull(testUser.getId());
	
	}
	
	public void a_createUserNotExist() {
		User testUser = new User(null,"nom", "prenom", 15, "null", "null");
		result = service.create(testUser);
		System.out.println("DEBUG : user"+ result.getId());
		assertTrue(testUser.getEmail() != "momo@yahoo.fr");

	}
	
	public void a_createUserNot() {
		User testUser = new User(null,"nom", "prenom", 15, "null", "null");
		result = service.create(testUser);
		System.out.println("DEBUG : user"+ result.getId());

	}
	
	@Test
	@Ignore
	public void b_deleteUser() {
		
		boolean resultat = service.delete(result);
		assertTrue(resultat);
	}
	
	@After
	public void afterMethod() {
		System.out.println("after test method");
		if(result != null && result.getId() != null) {
			b_deleteUser();
		}
	}
}
