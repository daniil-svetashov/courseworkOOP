package ua.edu.op.webapplication.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.edu.op.webapplication.image.Image;

import java.io.IOException;
import java.util.List;

@Controller
public class NewsController {

    private NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping("/news_temp")
    private String news_temp(Model model)
    {

        List<News> news = service.getAllNews();
        model.addAttribute("list_news",news);
        return "news_temp";
    }

    @PostMapping("/news_temp/add_news")
    private String addNews(@RequestParam("file") MultipartFile file, News news) throws IOException
    {
        service.saveNews(news,file);
        return "redirect:/news_temp";
    }

    @GetMapping("/news_temp/add_news")
    private String addNews(Model model)
    {
        model.addAttribute("new_news", new News());
        return "add_news";
    }





}
