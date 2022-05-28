package ua.edu.op.webapplication.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.edu.op.webapplication.image.Image;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class NewsController {

    private NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping("/news")
    private String news_temp(Model model) {

        List<News> news = service.getAllNews();
        model.addAttribute("list_news", news);
        return "news";
    }

    @PostMapping("/news/add_news")
    private String addNews(@ModelAttribute("new_news") @Valid News news,BindingResult result, @RequestParam("file") MultipartFile file)
            throws IOException {
        if(result.hasErrors())
        {
            System.out.println("WE WERE HERE!");
            return "add_news";
        }
        if(file.isEmpty()) { //проверят, что мы добавили фотку
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


}