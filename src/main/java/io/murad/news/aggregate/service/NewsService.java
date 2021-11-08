package io.murad.news.aggregate.service;

import io.murad.news.aggregate.model.Article;
import io.murad.news.aggregate.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NewsService {

    private final ArticleRepository articleRepository;

    public void storeNews() throws IOException {
        List<Article> articles = new ArrayList<Article>();
        Document doc = Jsoup.connect("https://www.prothomalo.com/").get();
        log.info(doc.title());
        Elements prothomAloNews = doc.getElementsByClass("newsHeadline-m__title-link__1puEG");
        for(Element news : prothomAloNews){
//            log.info(e.text());
//            log.info(e.attr("href"));
            String title = news.text();
            String url = news.attr("href");

                articles.add(new Article(title, url));
                log.info(String.valueOf(news.childNodes()));

//            log.info(String.valueOf(news.childNode(1).attr("src")));
//            Elements images = e.getElementsByTag("img");
//            for(Element image : images){
//                String imgUrl = image.absUrl("src");
//                log.info(imgUrl);
//            }
        }
//        articleRepository.saveAll(articles);


//        Elements image = doc.select("img.ClassName qt-image");
//        Elements image = doc.getElementsByClass("qt-image");
//        for (Element img : image) {
//            String src = img.absUrl("src");
//            log.info(src);
//        }
    }
}
