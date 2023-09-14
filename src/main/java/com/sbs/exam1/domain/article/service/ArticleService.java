package com.sbs.exam1.domain.article.service;

import com.sbs.exam1.domain.article.entity.Article;
import com.sbs.exam1.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public List<Article> findLatest(int count) {
        return articleRepository.findLatest(count);
    }

    public List<Article> findLatestAfterId(int count, long lastId) {
        return articleRepository.findLatestAfterId(count, lastId);
    }
}
