package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entities.User;

@Repository
public interface IDaoUser  extends JpaRepository<User, Long>{
	
	@Query(value="from User where email = :emailParam and pwd = :pwdParam")
	public User findByEmail(@Param("emailParam") String email, @Param("pwdParam") String pwd);
	
	@Query(value="from User where name = :nameParam")
	public boolean existsByName(@Param("nameParam") String name);
	
//    @Query(value = "UPDATE User set email =:emailVerif, pwd =:pwdVerif, name =:nameVerif, age =:ageVerif, firstname =:firstnameVerif where id = :idParam",
//            nativeQuery = true)
//    public void 


}
