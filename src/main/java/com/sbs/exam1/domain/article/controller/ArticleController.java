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

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);

        return "usr/article/list";
    }

    @GetMapping("/listMore")
    @ResponseBody
    public String showListMore(Model model) {
        return """
                <tr>
                    <td>1000</td>
                    <td>제목 1000</td>
                </tr>
                <tr>
                    <td>1001</td>
                    <td>제목 1001</td>
                </tr>
                <tr>
                    <td>1002</td>
                    <td>제목 1002</td>
                </tr>
                """;
    }
}
