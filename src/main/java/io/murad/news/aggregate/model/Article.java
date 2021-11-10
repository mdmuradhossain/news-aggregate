package io.murad.news.aggregate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String url;

    @Column
    private String imgUrl;

    @Lob
    @Column
    private String content;

    public Article(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Article(String title, String url, String imgUrl) {
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public Article(String title, String url, String imgUrl,String content) {
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
        this.content = content;
    }
}
