package org.sample.controller;

import java.util.List;
import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.LoadTeams;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    SampleService sampleService;
    LoadTeams LoadTeams;
    //LoadTeams loadTeams;

    
    @RequestMapping(value = "/Member", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
       //Part two Show all teams, that the user can choose:
    	model.addObject("signupForm", new SignupForm());  

        return model;
    }
    
        @RequestMapping(value = "/showTeams", method = RequestMethod.GET) //You should show the teams for choosing later
    public ModelAndView showTeams() {
    	ModelAndView model;
       //Part two Show all teams, that the user can choose:
        List<org.sample.model.Team> Team = LoadTeams.findAll();
        model = GetListOfAllTeams(Team);
        return model;
    }

    

    @RequestMapping(value = "/Member/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes, String Teamname) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("show");
            } catch (InvalidUserException e) {
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("index");
        }   	
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }
    
    public ModelAndView GetListOfAllTeams(List<org.sample.model.Team> TeamList) {
    ModelAndView AllTeams = null;                                            //Again error handling missed
    for(org.sample.model.Team Team : TeamList)               {               //Todo Make interface with both ListMakers
    AllTeams.addObject(Team);
    }
    return AllTeams;
    }

}


