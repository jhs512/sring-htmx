package com.sbs.exam1.domain.article.repository;

import com.sbs.exam1.domain.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>() {{
        IntStream.iterate(100, i -> i - 1)
                .limit(100)
                .forEach(i -> {
                    add(new Article((long) i, "제목 " + i));
                });
    }};

    public List<Article> findAll() {
        return articles;
    }

    public List<Article> findLatest(int count) {
        return articles.subList(0, count);
    }

    public List<Article> findLatestAfterId(int count, long lastId) {
        int index = IntStream.range(0, articles.size())
                .filter(i -> articles.get(i).getId() == lastId)
                .findFirst()
                .orElse(-1);

        if (index == -1 || index + 1 >= articles.size()) {
            return Collections.emptyList();
        }

        return articles.stream()
                .skip(index + 1)
                .limit(count)
                .collect(Collectors.toList());
    }
}
