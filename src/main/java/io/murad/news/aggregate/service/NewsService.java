package io.murad.news.aggregate.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class NewsService {

    public void storeNews() throws IOException {
        Document doc = Jsoup.connect("https://www.prothomalo.com/").get();
        log.info(doc.title());
    }
}
