/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller;

import java.util.List;
import org.sample.controller.service.SampleTakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anubis
 */
@Controller
public class PrintClass {

    @Autowired
    SampleTakerService SampleTakerService;

    //Simple Request Controller without exceptionhandling
    @RequestMapping(value = "/Print/SearchById", method = RequestMethod.GET)
    public ModelAndView getSearchResult(@RequestParam("Id") Long Id) {
        ModelAndView Profiles = new ModelAndView("profile");
        List<org.sample.model.User> Userlist = SampleTakerService.findById(Id);  //Ok, User should be unique but you never know
        Profiles = MakeAUserList(Userlist);
        return Profiles;
    }

    @RequestMapping(value = "/Print/ListAllUsers", method = RequestMethod.GET) //Ok, was not wanted, but here all user are "printed" out
    public ModelAndView getEverything() {
        ModelAndView AllProfiles = new ModelAndView("EveryUser");
        List<org.sample.model.User> Userlist = SampleTakerService.All();
        AllProfiles = MakeAUserList(Userlist);
        return AllProfiles;
    }

    public ModelAndView MakeAUserList(List<org.sample.model.User> Userlist) { // List of all users, entered to the ModelAndView.
        ModelAndView ListOfUsers = null;     ///Again because of time stress: error and null pointer risk ignored
        for (org.sample.model.User FoundUser : Userlist) {   //But it's clear here is missed errorhandling...
            ListOfUsers.addObject(FoundUser);
        }

        return ListOfUsers;
    }

}
