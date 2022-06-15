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
    @Column(name="imageId")
    private long imageId;

    @Column(name="name")
    private String name;

    @Column(name="originalFileName")
    private String originalFileName;

    @Column(name="contentType")
    private String contentType;

    @Column(name="size")
    private Long size;

    @Column(name="bytes", columnDefinition = "BYTEA")
    private byte[] bytes;

    @OneToOne(mappedBy = "image")
    private News news;


    public void addNewsToImage(News news)
    {
        news.setImage(this);
    }
}