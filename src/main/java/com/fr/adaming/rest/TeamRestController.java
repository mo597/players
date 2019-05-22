package com.fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entities.Team;
import com.fr.adaming.service.ITeamService;

@Controller
@RestController
@RequestMapping(path = "/equipe")
public class TeamRestController {
	
	@Autowired
	private ITeamService teamService;
	
	@RequestMapping(path = "/search",method = RequestMethod.GET)
	private Team readByName(@PathVariable String name) {
		return teamService.readByName(name);
	}
	
	@RequestMapping(path="/liste", method = RequestMethod.GET)
	private List<Team> readAll() {
		return teamService.readAll();
	}
	
	@RequestMapping(path="/nouvelleequipe")
	private Team newEquipe(@RequestBody Team team) {
		Team newTeam = teamService.create(team);
		return newTeam;
	}

}

