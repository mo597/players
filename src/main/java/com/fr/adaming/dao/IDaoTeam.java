package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entities.Team;

@Repository
public interface IDaoTeam extends JpaRepository<Team, Long>{

	@Query(value="from Team where name = :nameParam")
	public Team findByName(@Param("nameParam") String name);

}
