package com.sbs.exam1.domain.article.controller;

import com.sbs.exam1.domain.article.entity.Article;
import com.sbs.exam1.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final int pageItemsCount = 50;

    @GetMapping("/list")
    public String showList(Model model) {
        return "usr/article/list";
    }

    @GetMapping("/listMore")
    @ResponseBody
    public Map showListMore(long lastId, Model model) {
        List<Article> articles = articleService.findLatestAfterId(pageItemsCount, lastId);

        if (articles.isEmpty())
            return Map.of(
                    "resultCode", "S-2",
                    "msg", "성공"
            );

        StringBuilder sb = new StringBuilder();

        for (Article article : articles) {
            sb.append("<tr>");

            sb.append("<td>");
            sb.append(article.getId());
            sb.append("</td>");

            sb.append("<td>");
            sb.append(article.getTitle());
            sb.append("</td>");

            sb.append("</tr>");
        }

        return Map.of(
                "resultCode", "S-1",
                "msg", "성공",
                "html", sb.toString(),
                "lastId", articles.get(articles.size() - 1).getId()
        );
    }
}
