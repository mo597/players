package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entities.Team;

public interface ITeamService {
	
//	@Autowired
//	private final IDaoTeam daoTeam;

	public Team create(Team team);
//	{
//		 daoTeam.save(team);
//	}
	
	public Team readByName(String name);

	
	public List<Team> readAll();

	public boolean delete(Team team) ;
}
