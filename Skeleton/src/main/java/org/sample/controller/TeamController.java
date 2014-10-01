/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller;

import javax.validation.Valid;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignUpTeam;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Anubis
 */

@Controller
public class TeamController {

    @Autowired
    SampleService ServiceTeam;
    
    @RequestMapping(value = "/Team", method = RequestMethod.GET)
    public ModelAndView newteam() {
        ModelAndView model2 = new ModelAndView("newTeam");
        model2.addObject("SignUpTeam", new SignUpTeam());
        return model2;
    }
    
        @RequestMapping(value = "/Team/createTeam", method = RequestMethod.POST)
            public ModelAndView createTeam(@Valid SignUpTeam Signupteam, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model2;    	
    	if (!result.hasErrors()) {
            try {
            	//sampleService.saveFrom(Signupteam); // Fehlen noch Klassen
            	model2 = new ModelAndView("show");
            } catch (InvalidUserException e) {
            	model2 = new ModelAndView("newTeam");
            	model2.addObject("page_error", e.getMessage());
            }
        } else {
        	model2 = new ModelAndView("newTeam");
        }   	
    	return model2;
}
            
            
}
