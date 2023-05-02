package com.project.cosmetics_store.controllers;

import com.project.cosmetics_store.models.Role;
import com.project.cosmetics_store.models.User;
import com.project.cosmetics_store.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

/**
 * Class for registration logic
 * @author Anastasia Ovcharenko
 */
@Controller
public class RegistrationController {


    @Autowired
    private UserRepository userRepository;

    /**
     * method for rendering registration page
     * @return rendered registration page
     * @author Anastasia Ovcharenko
     */
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    /**
     * method for sending registrated user data to database
     * @param user - current user
     * @param model - holder of model attributes
     * @return rendered login page via redirect
     * @author Anastasia Ovcharenko
     */
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.put("message", "User exists");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
