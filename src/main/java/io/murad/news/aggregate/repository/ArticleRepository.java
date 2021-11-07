package io.murad.news.aggregate.repository;

import io.murad.news.aggregate.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Long, Article> {
}
