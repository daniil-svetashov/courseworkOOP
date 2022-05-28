package ua.edu.op.webapplication.image;


import lombok.Data;
import ua.edu.op.webapplication.news.News;

import javax.persistence.*;

@Entity
@Table(name="Image")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long imageId;

    private String name;

    private String originalFileName;

    private String contentType;

    private Long size;

    @Column(columnDefinition = "BYTEA")
    private byte[] bytes;

    @OneToOne(mappedBy = "image")
    private News news;


    public void addNewsToImage(News news)
    {
        news.setImage(this);
    }
}
