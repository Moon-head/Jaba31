package by.kremen.theatre.controller;

import by.kremen.theatre.form.PerformanceForm;
import by.kremen.theatre.model.*;
import by.kremen.theatre.repository.ActorRepository;
import by.kremen.theatre.repository.PerformanceRepository;
import by.kremen.theatre.repository.TheaterRepository;
import by.kremen.theatre.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;



@Slf4j
@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ActorRepository actorRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/admin/main")
    public String main(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", userRepository.findByUsername(user.getUsername()));
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("performances", performanceRepository.findAll());
        log.info("get admin main");
        return "mainAdmin";
    }

    @PostMapping("/admin/performance")
    public String addUser(PerformanceForm performanceForm, Model model, @AuthenticationPrincipal User user){

        Theater theater = theaterRepository.findById(performanceForm.theater_id);
        Performance performance = new Performance(performanceForm, theater);

        //int perf_id = (int)model.getAttribute("id");

        //System.out.println(perf.getId());
        //System.out.println(perf.getTitle());

        //review.setPerformance(performanceRepository.findById(Integer.parseInt(perf_id)));
        performanceRepository.save(performance);
        log.info("create new performance");
        return "redirect:/admin/main";
    }

    @GetMapping("/admin/performance")
    public String mainAdd(@AuthenticationPrincipal User user, Model model) {
       /* if(user.getAuthorities()!= Collections.singleton(Role.ADMIN)){

            model.addAttribute("message", "If you want add dishes you have to be an ADMIN");
            return "login";
        }*/

        //Long idL = Long.getLong(perf_id);
        //Performance performance = performanceRepository.findById(idL);
        List<Theater> theaters = theaterRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("actors", actors);
        model.addAttribute("theaters", theaters);
        log.info("get admin add performance");

        return "performance";
    }

    @GetMapping("/admin/performanceUpd")
    public String mainUpd(@RequestParam String perf_id, @AuthenticationPrincipal User user, Model model) {
       /* if(user.getAuthorities()!= Collections.singleton(Role.ADMIN)){

            model.addAttribute("message", "If you want add dishes you have to be an ADMIN");
            return "login";
        }*/

        //Long idL = Long.getLong(perf_id);
        //Performance performance = performanceRepository.findById(idL);
        Performance performance = performanceRepository.findById(Integer.parseInt(perf_id));
        List<Theater> theaters = theaterRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("actors", actors);
        model.addAttribute("theaters", theaters);
        model.addAttribute("performance", performance);
        model.addAttribute("id", perf_id);
        log.info("get admin update performance");

        return "performanceUpd";
    }

    @PostMapping("/admin/performanceUpd")
    public String updUser(@RequestParam String perf_id, PerformanceForm performanceForm, Model model, @AuthenticationPrincipal User user){
System.out.println(perf_id);
        Performance performance = performanceRepository.findById(Integer.parseInt(perf_id));
        Theater theater = theaterRepository.findById(performanceForm.theater_id);

        performance.setTitle(performanceForm.getTitle());
        performance.setDate(performanceForm.getDate());
        performance.setTheater(theater);

        //int perf_id = (int)model.getAttribute("id");

        //System.out.println(perf.getId());
        //System.out.println(perf.getTitle());

        //review.setPerformance(performanceRepository.findById(Integer.parseInt(perf_id)));
        performanceRepository.save(performance);

        log.info("admin update performance");

        return "redirect:/admin/main";
    }

    @GetMapping("/admin/performanceDel")
    public String mainDel(@RequestParam String perf_id, @AuthenticationPrincipal User user, Model model) {
       /* if(user.getAuthorities()!= Collections.singleton(Role.ADMIN)){

            model.addAttribute("message", "If you want add dishes you have to be an ADMIN");
            return "login";
        }*/

        //Long idL = Long.getLong(perf_id);
        //Performance performance = performanceRepository.findById(idL);
        performanceRepository.delete(performanceRepository.findById(Integer.parseInt(perf_id)));

        log.info("admin delete performance");

        return "redirect:/admin/main";
    }
}
