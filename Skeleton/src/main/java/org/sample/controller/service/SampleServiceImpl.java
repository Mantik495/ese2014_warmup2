package org.sample.controller.service;

import java.util.List;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    UserDao userDao;
    @Autowired
    AddressDao addDao;
    @Autowired
    LoadTeams LoadTeams;

    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException {

        String firstName = signupForm.getFirstName();
        String TeamToSet = signupForm.getTeam();
        if (!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }

        Address address = new Address();
        address.setStreet("TestStreet-foo");

        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        
        List<org.sample.model.Team> ListOfTeams = LoadTeams.findAll();

        for (org.sample.model.Team ExistingTeam : ListOfTeams) {
            
            if(ExistingTeam.getTeam().equals(TeamToSet))
                {
                    user.setTeam(ExistingTeam);
                }
            }
        
            user = userDao.save(user);   // save object to DB
        
        //Iterable<User> users = userDao.findAll();
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID

        signupForm.setId(user.getId());
        return signupForm;

    }
}
