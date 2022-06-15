package ua.edu.op.webapplication.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class FeedbackController {

    private FeedbackService service;

    @Autowired
    public FeedbackController(FeedbackService service) {
        this.service = service;
    }


    @PostMapping("/")
    public String processForm(@Valid @ModelAttribute("new_feedback") Feedback feedback, BindingResult result) {

        if (result.hasErrors()) {
            return "index";
        }
        service.addFeedback(feedback);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("new_feedback", new Feedback());
        return "index";
    }

}
