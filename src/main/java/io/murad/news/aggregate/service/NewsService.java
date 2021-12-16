package io.murad.news.aggregate.service;

import io.murad.news.aggregate.model.Article;
import io.murad.news.aggregate.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class NewsService {

//    Locale localeFromBuilder = new Locale.Builder().setLanguage("bn").setRegion("BD").build();

    private final ArticleRepository articleRepository;

    @Scheduled(fixedRate = 3600 * 1000)
    public void storeNews() throws IOException {
        List<Article> articles = new ArrayList<Article>();
        Document doc = Jsoup.connect("https://www.prothomalo.com/").get();
        Connection.Response resp = Jsoup.connect("https://www.prothomalo.com/") //
                .timeout(20000) //
                .method(Connection.Method.GET) //
                .execute();

        log.info(doc.title());
        Elements prothomAloNews = doc.getElementsByClass("newsHeadline-m__title-link__1puEG");
        for (Element news : prothomAloNews) {
//            log.info(e.text());
//            log.info(e.attr("href"));
            String title = news.text();
            String url = news.attr("href");

//                articles.add(new Article(title, url));
//                log.info(news);

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
        Document doc2 = Jsoup.connect("https://www.prothomalo.com/collection/latest").get();
        Elements latestNews = doc2.getElementsByClass("customStoryCard9-m__wrapper__yEFJV");
//        Elements latestNews = doc2.select("div.customStoryCard9-m__wrapper__yEFJV");
        Article article = new Article();
//        System.out.println(latestNews);
        for (Element ln : latestNews) {
            String title = ln.getElementsByTag("h2").text();
            String content = ln.getElementsByTag("span").text();
            String url = ln.getElementsByTag("a").attr("href");
            String time = ln.getElementsByTag("time").text();
            String imgUrl = ln.getElementsByTag("img").attr("src");

            if (title.equals(article.getTitle()) || content.equals(article.getContent()) || url.equals(article.getUrl())) {
                log.info("Already Exists");
            } else {
                articles.add(new Article(title, url, imgUrl, content));
            }


            System.out.println(ln.getElementsByTag("h2").text());
//            System.out.println(Objects.requireNonNull(ln.getElementsByTag("a").first()).text());
            System.out.println(ln.getElementsByTag("a").attr("href"));
//            System.out.println(ln.getElementsByTag("img").attr("src"));
//            System.out.println(ln.getElementsByTag("picture"));
            System.out.println(time);
            System.out.println(imgUrl);
        }

        articleRepository.saveAll(articles);
//            Elements latestNewsElements = Objects.requireNonNull(latestNews.first()).getAllElements();
//            System.out.println(latestNewsElements);
//
//        for(Element ln : latestNewsElements){
//            System.out.println(ln.getElementsByTag("h2").text());
//            System.out.println(Objects.requireNonNull(ln.getElementsByTag("a")).attr("href"));
//            System.out.println(ln.getElementsByTag("img").attr("src"));
//        }
    }

    public List<Article> getAllNews() {
        return articleRepository.findAll();
    }
}
