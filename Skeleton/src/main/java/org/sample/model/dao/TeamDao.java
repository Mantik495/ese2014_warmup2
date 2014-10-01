/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.model.dao;
import org.sample.model.Team;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anubis
 */
public interface TeamDao extends CrudRepository<Team,Long>{
    
}
