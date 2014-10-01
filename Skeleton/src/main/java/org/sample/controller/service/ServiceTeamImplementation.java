/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller.service;

import org.sample.controller.pojos.SignUpTeam;
import org.sample.model.Team;
import org.sample.model.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anubis
 */
public class ServiceTeamImplementation {

    @Autowired
    TeamDao teamdao;

    public SignUpTeam saveFrom(SignUpTeam signupteam) {

        String team = signupteam.getTeam();
        String date = signupteam.getDate();
        
        //Todo Errorcondition
        
        Team TeamToSave = new Team();
        TeamToSave.setTeam(team);
        TeamToSave.setDate(date);

        TeamToSave = teamdao.save(TeamToSave);
        
        signupteam.setId(TeamToSave.getId());
        return signupteam;
           
    }
}
