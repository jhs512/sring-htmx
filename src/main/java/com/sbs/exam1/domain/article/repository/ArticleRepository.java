package com.sbs.exam1.domain.article.repository;

import com.sbs.exam1.domain.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>() {{
        IntStream.range(1, 10).forEach(i -> {
            add(new Article((long) i, "제목 " + i));
        });
    }};

    public List<Article> findAll() {
        return articles;
    }
}
