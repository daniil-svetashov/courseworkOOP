package ua.edu.op.webapplication.news;


import lombok.Data;
import ua.edu.op.webapplication.image.Image;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long newsId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    private String link;

    private String date;

    public News(long newsId, String title, String text, String link, String date, Image image) {
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
