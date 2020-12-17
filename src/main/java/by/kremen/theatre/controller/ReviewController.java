package by.kremen.theatre.controller;

import by.kremen.theatre.model.Performance;
import by.kremen.theatre.model.Review;
import by.kremen.theatre.model.User;
import by.kremen.theatre.repository.PerformanceRepository;
import by.kremen.theatre.repository.ReviewRepository;
import by.kremen.theatre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PerformanceRepository performanceRepository;

    @PostMapping("/review")
    public String addUser(Review review, Model model, @AuthenticationPrincipal User user){

        int perf_id = (int)model.getAttribute("id");
        review.setUser(user);

        review.setPerformance((Performance)model.getAttribute("performance"));
        reviewRepository.save(review);
        return "redirect:/main";
    }

    @GetMapping("/review")
    public String main(@RequestParam String perf_id, @AuthenticationPrincipal User user, Model model) {
        Long idL = Long.getLong(perf_id);
        //Performance performance = performanceRepository.findById(idL);
        Performance performance = performanceRepository.findById(Integer.parseInt(perf_id));
        model.addAttribute("performance", performance);
        model.addAttribute("id", perf_id);

        return "review";
    }
}
