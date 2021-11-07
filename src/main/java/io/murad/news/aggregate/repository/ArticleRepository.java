package io.murad.news.aggregate.repository;

import io.murad.news.aggregate.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Long, Article> {
}
