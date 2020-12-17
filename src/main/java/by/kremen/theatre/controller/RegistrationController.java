package by.kremen.theatre.controller;


import by.kremen.theatre.model.User;
import by.kremen.theatre.model.Role;
import by.kremen.theatre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String registration(){

        log.info("get registration");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        log.info("registere new user");
        return "redirect:/login";
    }
}
