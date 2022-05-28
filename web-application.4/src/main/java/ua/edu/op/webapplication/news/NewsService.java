package ua.edu.op.webapplication.news;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.edu.op.webapplication.image.Image;

import java.io.IOException;
import java.util.List;


@Service
public class NewsService {

    private NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public void saveNews(News news, MultipartFile file) throws IOException {
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            news.addImageToNews(image);
            image.addNewsToImage(news);
        }
        //добавить логи
        repository.save(news);
    }

    public List<News> getAllNews()
    {
        return repository.findAllByOrderByNewsIdDesc();
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setBytes(file.getBytes());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setOriginalFileName(image.getOriginalFileName());
        return image;
    }
}
