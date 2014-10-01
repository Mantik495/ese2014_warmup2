/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignUpTeam;

/**
 *
 * @author Anubis
 */
public interface ServiceTeam {
    
        public SignUpTeam saveFrom(SignUpTeam Signupteam) throws InvalidUserException;
   
}
