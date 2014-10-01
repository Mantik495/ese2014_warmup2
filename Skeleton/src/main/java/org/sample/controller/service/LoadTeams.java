/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller.service;

import org.sample.model.Team;
import org.springframework.data.repository.Repository;
import java.util.List;

/**
 *
 * @author Anubis
 */
public interface LoadTeams extends Repository<Team, Long> {
    
 List<Team> findByTeam(String Team);    
 List<Team> findAll();  
}
