package ua.edu.op.webapplication.news;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ua.edu.op.webapplication.image.Image;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "news")
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="newsId")
    private long newsId;

    @Column(name="title", columnDefinition = "VARCHAR(100)")
    @Size(min=2, max=100, message="Заголовок должен содержать от 2х до 100 символов")
    private String title;

    @Column(name="text", columnDefinition = "VARCHAR(600)")
    @Size(min=8, max=600, message="Текст должен содержать от 8 до 600 символов")
    private String text;

    @Column(name="link")
    @Size(min=8, max=255, message="Ссылка должна содержать от 8 до 255 символов")
    private String link;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Вы должны указать дату")
    private Date date;

    public News(long newsId, String title, String text, String link, Date date, Image image) {
        this.newsId = newsId;
        this.title = title;
        this.text = text;
        this.link = link;
        this.date = date;
        this.image = image;
    }

    public News() {
    }

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="image_id", referencedColumnName = "imageId")
    private Image image;

    public void addImageToNews(Image image)
    {
        image.setNews(this);
    }
}