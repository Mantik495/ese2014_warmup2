/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller.pojos;

import java.util.Date;

/**
 *
 * @author Anubis
 */

public class SignUpTeam {

    private Long id;
    private String Team;
    private String Date;

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getDate() {
        return Date;

    }

    public void setDate(String Date) {
                Date d = new Date();
                Date = d.toString();
                this.Date = Date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
