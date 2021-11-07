package io.murad.news.aggregate.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class NewsService {


    public void storeNews() throws IOException {
        Document doc = Jsoup.connect("https://www.prothomalo.com/").get();
        log.info(doc.title());
        Elements el = doc.getElementsByClass("newsHeadline-m__title-link__1puEG");
        for(Element e : el){
            log.info(e.text());
            log.info(e.attr("href"));
            Elements images = e.getElementsByTag("img");
            for(Element image : images){
                String imgUrl = image.absUrl("src");
                log.info(imgUrl);
            }
        }

//        Elements image = doc.select("img.ClassName qt-image");
//        Elements image = doc.getElementsByClass("qt-image");
//        for (Element img : image) {
//            String src = img.absUrl("src");
//            log.info(src);
//        }
    }
}
