package by.kremen.theatre.controller;

import by.kremen.theatre.model.Performance;
import by.kremen.theatre.model.Review;
import by.kremen.theatre.model.User;
import by.kremen.theatre.repository.PerformanceRepository;
import by.kremen.theatre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerformanceRepository performanceRepository;


    @GetMapping("/admin/main")
    public String main(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", userRepository.findByUsername(user.getUsername()));
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("performances", performanceRepository.findAll());
        return "mainAdmin";
    }

    @PostMapping("/admin/performance")
    public String addUser(@RequestParam String perf_id, Performance performance, Model model, @AuthenticationPrincipal User user){

        //Performance perf = (Performance)model.getAttribute("performance");
        //int perf_id = (int)model.getAttribute("id");

        //System.out.println(perf.getId());
        //System.out.println(perf.getTitle());

        //review.setPerformance(performanceRepository.findById(Integer.parseInt(perf_id)));
        performanceRepository.save(performance);
        return "redirect:/main";
    }

    @GetMapping("/admin/performance")
    public String main(@RequestParam String perf_id, @AuthenticationPrincipal User user, Model model) {
        Long idL = Long.getLong(perf_id);
        //Performance performance = performanceRepository.findById(idL);
        Performance performance = performanceRepository.findById(Integer.parseInt(perf_id));
        model.addAttribute("performance", performance);
        model.addAttribute("id", perf_id);

        return "review";
    }

}
