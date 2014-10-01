/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Anubis
 */
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    
    private String Team;
    private String Date;

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getDate(String Date) {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
