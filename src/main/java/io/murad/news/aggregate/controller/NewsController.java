package io.murad.news.aggregate.controller;

import io.murad.news.aggregate.model.Article;
import io.murad.news.aggregate.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(path="/news")
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping()
    public String news(Model model) throws IOException {
        newsService.storeNews();
        model.addAttribute("articles",newsService.getAllNews());
        return "news/news";
    }

}
