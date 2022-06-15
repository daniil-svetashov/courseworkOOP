package ua.edu.op.webapplication.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class NewsController {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    class BadRequestException extends RuntimeException {
    }

    private NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping("/news")
    private String news(Model model) {

        List<News> news = service.getAllNews();
        model.addAttribute("list_news", news);
        return "news";
    }

    @PostMapping("/news/add_news")
    private String addNews(@ModelAttribute("new_news")
                           @Valid News news, BindingResult result,
                           @RequestParam("file") MultipartFile file)
            throws IOException {
        if (result.hasErrors()) {
            return "add_news";
        }
        if (file.isEmpty()) {
            return "add_news";
        }
        service.saveNews(news, file);
        return "redirect:/news";
    }

    @GetMapping("/news/add_news")
    private String addNews(Model model) {
        model.addAttribute("new_news", new News());
        return "add_news";
    }


    @GetMapping("/news/control")
    private String editNews(Model model) {
        List<News> news = service.getAllNews();
        model.addAttribute("list_news", news);
        return "control";
    }

    @GetMapping("/news/control/delete_news")
    private String deleteNewsById(@RequestParam("id") long id) {
        service.deleteNewsById(id);
        return "redirect:/news/control";
    }

    @GetMapping("/news/control/edit_news")
    private String editNewsById(@RequestParam("id") long id, Model model) {
        Optional<News> news = service.getNewsById(id);

        if (news.isEmpty()) {
            throw new BadRequestException();
        } else {
            model.addAttribute("new_news", news.get());
            return "add_news";
        }

    }


}