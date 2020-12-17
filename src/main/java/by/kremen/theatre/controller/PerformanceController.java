package by.kremen.theatre.controller;

import by.kremen.theatre.model.User;
import by.kremen.theatre.model.Performance;
import by.kremen.theatre.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

    @PostMapping("/performance")
    public String addUser(Performance performance, Model model){


        performanceRepository.save(performance);
        return "redirect:/main";
    }

    @GetMapping("/performance")
    public String main(@AuthenticationPrincipal User user, Model model) {
        //if(user.getRoles()!=Collections.singleton(Role.ADMIN)){
        //  model.addAttribute("message", "If you want add dishes you have to be an ADMIN");
        //  return "login";
        //}
        return "performance";
    }
}
