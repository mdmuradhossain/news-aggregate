package io.murad.news.aggregate.controller;

import io.murad.news.aggregate.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(path="/news")
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping()
    public String news() throws IOException {
        newsService.storeNews();
        return "news/news";
    }
}
