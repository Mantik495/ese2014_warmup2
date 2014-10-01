/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.controller.service;

import java.util.List;
import org.sample.model.User;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Anubis
 */

public interface SampleTakerService extends Repository <User, Long> {
    
      List<User> findByfirstName(String firstName);
      List<User> findById(Long id); // Here the user can be found by his ID.
      List<User> All();
}





