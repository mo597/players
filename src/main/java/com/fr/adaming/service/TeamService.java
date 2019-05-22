package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.fr.adaming.dao.IDaoTeam;
import com.fr.adaming.entities.Team;

@Service
public class TeamService implements ITeamService {
	
	@Autowired
	private IDaoTeam daoTeam;
	
	//Définition d'un variable logger référence à l'instance Logger
	Logger logger = Logger.getLogger(UserService.class);
	
	@Override
	public Team create(Team team) {
		try {
//			if(daoTeam.findByName(team.getName()) != null) {
//				daoTeam.findByName(team.getName());
//				System.out.println("DEBUG l'équipe" + team.getName() +"existe déjà");
				
//			} 
			if(team != null && (team.getId()==null || team.getId()==0)) {
				team = daoTeam.save(team);
				
				
			} return team;
//				else {daoTeam.findById(team.getId());
//					return team;
//			}
//			
//			//Insérer des if et else pour passer de create à updater si user existant
			} catch (Exception e) {
				e.printStackTrace();
				logger.warn("L'équipe existe déjà");
				team = daoTeam.findByName(team.getName());
				return team;
			}
	}

	@Override
	public Team readByName(String name) {
		Team foundTeam = daoTeam.findByName(name);
		if(foundTeam == null) {
			System.out.println("L'équipe n'existe pas");
			return null;
		}else {
			return foundTeam;
		}
	}

	@Override
	public List<Team> readAll() {
		List<Team> listTeam = daoTeam.findAll();
		if(listTeam.size() == 0) {
			System.out.println("Il n'y a pas encore d'équipe inscrite");
			return null;
		} else {
			
			System.out.println(listTeam);
			return listTeam;
		}
	}

	@Override
	public boolean delete(Team team) {
		if(team.getId() == 0 ) {
			System.out.println("Vous ne pouvez supprimer une équipe inexistante");
			return false;
		} else {
			daoTeam.delete(team);
			
			if(daoTeam.existsById(team.getId()))
				return false;
			else {
				System.out.println("Equipe supprimée !");
				return true;
			}		
		}
		//si le retour est null alors la valeur sera null
//			return null;
	}

	
}
