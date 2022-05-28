package ua.edu.op.webapplication;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/fanats")
    public String fanats() {
        return "fanats";
    }

    @GetMapping("/filmography")
    public String filmography() {
        return "filmography";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


    //----------------------------------------------
}
